package edu.nmt.minecraft.HomeWorldPlugin.arena;

import java.util.LinkedList;

import org.bukkit.entity.Player;

public class Team {

	private String teamName;
	private LinkedList<TeamPlayer> players;
	private String teamInfo;
	
	public Team(String teamName){
		players = new LinkedList<TeamPlayer>();
		this.teamName = teamName;
		this.teamInfo = teamName;
	}
	
	public String getName(){
		return teamName;
	}
	
	public String getInfo(){
		return teamInfo;
	}
	
	public LinkedList<TeamPlayer> getPlayers(){
		return players;
	}
	
	public boolean isReady(){
		if (players.size() == 0){
			return false;
		}
		for (TeamPlayer p: players){
			if (! p.isReady()){
				return false;
			}
		}
		return true;
	}
	
	public boolean contains(TeamPlayer p){
		return players.contains(p);
	}
	
	public boolean contains(Player p){
		for (TeamPlayer tp: players){
			if (tp.getPlayer().equals(p)){
				return true;
			}
		}
		return false;
	}
	
	public void addPlayer(Player p){
		players.add(new TeamPlayer(p));
	}
	
	public void addPlayer(TeamPlayer p){
		players.add(p);
	}
	
	public void removePlayer(Player p){
		for (TeamPlayer tp: players){
			if (tp.getPlayer().equals(p)){
				players.remove(tp);
			}
		}
	}
	
	public void removePlayer(TeamPlayer p){
		players.remove(p);
	}

	public void setReady(Player p) {
		for (TeamPlayer tp: players){
			if (tp.getPlayer().equals(p)){
				tp.setReady(true);
				return;
			}
		}
	}

	public void setDead(Player player) {
		for (TeamPlayer tp: players){
			if (tp.getPlayer().equals(player)){
				tp.setDead();
				return;
			}
		}
	}
	
	public void setAlive(Player player) {
		for (TeamPlayer tp: players){
			if (tp.getPlayer().equals(player)){
				tp.setAlive();
				return;
			}
		}
	}

	public boolean isAlive() {
		for (TeamPlayer tp: players){
			if (tp.isAlive()){
				return true;
			}
		}
		return false;
	}

	public void alertPlayers(String message) {
		for (TeamPlayer tp: players){
			tp.getPlayer().sendMessage(message);
		}
	}
}
