package Libraries;

import java.util.HashMap;

public class Pokedex {

	public static String[] Identify(String key){
		String[] p = new String[15];
		HashMap <String, String[]> map = new HashMap<>();
		map.put("Pikachu", new String[]{"35","55" ,"40" ,"50" ,"50" ,"90" ,"3" , "25" ,"4" ,"-1" ,"32", "Thunderbolt", "VoltTackle", "IronTail", "Tackle"});
		map.put("Raichu", new String[]{"60","90" ,"55" ,"90" ,"80" ,"110" ,"3" , "26" ,"4" ,"-1" ,"-1", "Thunder", "VoltTackle", "IronTail", "GigaImpact"});
		map.put("Sandshrew", new String[]{"50","75" ,"85" ,"20" ,"30" ,"40" ,"3" , "27" ,"11" ,"-1" ,"22", "Dig", "EarthPower", "RapidSpin", "RockSlide" });
		map.put("Sandslash", new String[]{"75","100" ,"110" ,"45" ,"55" ,"65" ,"3" , "28" ,"11" ,"-1" ,"-1", "Dig", "CrushClaw", "Earthquake", "RockSlide" });
		map.put("NidoranF", new String[]{"55","47" ,"52" ,"40" ,"40" ,"41" ,"2" , "29" ,"14" ,"-1" ,"16", "PoisonSting", "Peck", "DoubleKick", "Tackle" });
		map.put("Nidorina", new String[]{"70","62" ,"67" ,"55" ,"55" ,"56" ,"2" , "30" ,"14" ,"-1" ,"40", "PoisonSting", "Earthquake", "Power-UpPunch", "Stomp" });
		map.put("Nidoqueen", new String[]{"90","92" ,"87" ,"75" ,"85" ,"76" ,"2" , "31" ,"11" ,"14" ,"-1", "PoisonJab", "Earthquake", "GigaImpact", "Guillotine" });
		map.put("NidoranM", new String[]{"46","57" ,"40" ,"40" ,"40" ,"50" ,"2" , "32" ,"14" ,"-1" ,"16", "PoisonSting", "Peck", "DoubleKick", "Tackle" });
		map.put("Nidorino", new String[]{"61","72" ,"57" ,"55" ,"55" ,"65" ,"2" , "33" ,"14" ,"-1" ,"40", "PoisonSting", "Earthquake", "Power-UpPunch", "Stomp" }); 
		map.put("Nidoking", new String[]{"81","102" ,"77" ,"85" ,"75" ,"85" ,"2" , "34" ,"11" ,"14" ,"-1", "PoisonJab", "Earthquake", "GigaImpact", "Guillotine" });
		map.put("Absol", new String[]{"65","130" ,"60" ,"75" ,"60" ,"75" ,"2" , "359" ,"2" ,"-1" ,"-1", "NightSlash", "CrushClaw", "SacredSword", "AerialAce" });
		map.put("Torterra", new String[]{"95","109" ,"105" ,"75" ,"85" ,"56" ,"2", "389" ,"10" ,"11" ,"-1", "Earthquake", "LeafBlade", "GigaDrain", "RockSlide" });
		map.put("Pumpkaboo", new String[]{"49","66" ,"70" ,"44" ,"55","51" ,"3" , "710" ,"9" ,"10" ,"32", "ShadowSneak", "DarkPulse", "MegaDrain", "Pound" });

		 if (map.containsKey(key)) { 
	         p = map.get(key);
	     } 
		 return p;
	}
}
