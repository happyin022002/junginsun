/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageDBDAOCheckPsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOCheckPsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckPs
	  * </pre>
	  */
	public InlandRouteManageDBDAOCheckPsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOCheckPsRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("        	  FROM DUAL " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("#if(${r_inbound} == 'I')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				 WHERE EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("            	                 FROM prd_node n " ).append("\n"); 
		query.append("            		                WHERE n.nod_cd = @[i_rout_org_nod_cd] AND n.nod_tp_cd IN ('M', 'B'))  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	#if(${nod_tp_cd1} == 'Z')" ).append("\n"); 
		query.append("                		   AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                		                 FROM prd_node n " ).append("\n"); 
		query.append("                		                WHERE n.nod_cd = @[i_rout_dest_nod_cd] AND n.nod_tp_cd = 'Z')   " ).append("\n"); 
		query.append("    #else               " ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                    	   AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                		                 FROM prd_node n" ).append("\n"); 
		query.append("                		               WHERE n.nod_cd = @[i_rout_dest_nod_cd] AND n.nod_tp_cd != 'Z')    " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif(${r_inbound} == 'O')        	                                       " ).append("\n"); 
		query.append("        			 WHERE EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("            		                FROM prd_node n " ).append("\n"); 
		query.append("            		                WHERE n.nod_cd = @[i_rout_dest_nod_cd] AND n.nod_tp_cd IN ('M', 'B'))   " ).append("\n"); 
		query.append("	    #if(${nod_tp_cd1} == 'Z')    " ).append("\n"); 
		query.append("	                	   AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("	            		                 FROM prd_node n " ).append("\n"); 
		query.append("	            		                WHERE n.nod_cd = @[i_rout_org_nod_cd] AND n.nod_tp_cd = 'Z')  " ).append("\n"); 
		query.append("	    #else  " ).append("\n"); 
		query.append("	                         " ).append("\n"); 
		query.append("	                	   AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("	            		               FROM prd_node n " ).append("\n"); 
		query.append("	            		               WHERE n.nod_cd = @[i_rout_org_nod_cd] AND n.nod_tp_cd != 'Z')   " ).append("\n"); 
		query.append("	    #end         " ).append("\n"); 
		query.append("#elseif(${r_inbound} == 'M')    " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("        			WHERE  " ).append("\n"); 
		query.append("        			EXISTS " ).append("\n"); 
		query.append("					(        	" ).append("\n"); 
		query.append("        			    SELECT 'X' FROM mdm_yard " ).append("\n"); 
		query.append("        			   WHERE yd_fcty_tp_rail_rmp_flg='Y' AND " ).append("\n"); 
		query.append("        			    yd_cd = @[i_rout_org_nod_cd]" ).append("\n"); 
		query.append("        			)" ).append("\n"); 
		query.append("        			AND EXISTS" ).append("\n"); 
		query.append("        			( " ).append("\n"); 
		query.append("        			    SELECT 'X' FROM mdm_yard " ).append("\n"); 
		query.append("        			    WHERE yd_fcty_tp_rail_rmp_flg='Y' AND " ).append("\n"); 
		query.append("        			    yd_cd = @[i_rout_dest_nod_cd] " ).append("\n"); 
		query.append("        			) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}