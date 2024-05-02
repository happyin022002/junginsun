/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOPortLogHeadVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.09 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOPortLogHeadVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PortLog Head Search
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOPortLogHeadVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOPortLogHeadVORSQL").append("\n"); 
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
		query.append("SELECT COUNT(C.CRANE_NO) USED_CRANE," ).append("\n"); 
		query.append("ROUND((H.MVS / (DECODE(TO_NUMBER(SUBSTR(H.GROSS_WORK,1,INSTR(H.GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(H.GROSS_WORK,INSTR(H.GROSS_WORK,':')+1)/60),0,1," ).append("\n"); 
		query.append("TO_NUMBER(SUBSTR(H.GROSS_WORK,1,INSTR(H.GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(H.GROSS_WORK,INSTR(H.GROSS_WORK,':')+1)/60)))) /" ).append("\n"); 
		query.append("DECODE(H.MVS / (DECODE(TO_NUMBER(SUBSTR(H.GROSS_GANG,1,INSTR(H.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(H.GROSS_GANG,INSTR(H.GROSS_GANG,':')+1)/60),0,1," ).append("\n"); 
		query.append("TO_NUMBER(SUBSTR(H.GROSS_GANG,1,INSTR(H.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(H.GROSS_GANG,INSTR(H.GROSS_GANG,':')+1)/60))),0,1," ).append("\n"); 
		query.append("(H.MVS / (DECODE(TO_NUMBER(SUBSTR(H.GROSS_GANG,1,INSTR(H.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(H.GROSS_GANG,INSTR(H.GROSS_GANG,':')+1)/60),0,1," ).append("\n"); 
		query.append("TO_NUMBER(SUBSTR(H.GROSS_GANG,1,INSTR(H.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(H.GROSS_GANG,INSTR(H.GROSS_GANG,':')+1)/60))))),2) as AVG_CRANE," ).append("\n"); 
		query.append("H.GROSS_WORK      GROSS_WORK," ).append("\n"); 
		query.append("H.NET_WORK        NET_WORK," ).append("\n"); 
		query.append("H.LOSE_HR         LOST_TIME," ).append("\n"); 
		query.append("H.GROSS_GANG      GROSS_GANG," ).append("\n"); 
		query.append("H.NET_GANG        NET_GANG," ).append("\n"); 
		query.append("H.HATCH           HATCH_HANDL," ).append("\n"); 
		query.append("H.CON             GEAR_HANDL," ).append("\n"); 
		query.append("H.MVS             MOVE_HANDL," ).append("\n"); 
		query.append("H.GROSS_TML       TMNL_GROSS," ).append("\n"); 
		query.append("H.NET_TML         TMNL_NET," ).append("\n"); 
		query.append("H.GROSS_GC        PER_GANG_GROSS," ).append("\n"); 
		query.append("H.NET_GC          PER_GAN_NET," ).append("\n"); 
		query.append("H.COMMENCE		 COMMENCE," ).append("\n"); 
		query.append("H.COMPLETE		 COMPLETE" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_CRANE C" ).append("\n"); 
		query.append("WHERE  V.VSL_CD   		= H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   	= H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   	= H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  	= H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ 	= H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD   		= C.VSL_CD(+)" ).append("\n"); 
		query.append("AND    H.VOY_NO   		= C.VOY_NO(+)" ).append("\n"); 
		query.append("AND    H.DIR_CD   		= C.DIR_CD(+)" ).append("\n"); 
		query.append("AND    H.PORT_CD  		= C.PORT_CD(+)" ).append("\n"); 
		query.append("AND    H.CALL_IND 		= C.CALL_IND(+)" ).append("\n"); 
		query.append("AND    V.VSL_CD  		= @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  	= @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  	= @[dir_cd]" ).append("\n"); 
		query.append("AND    V.YD_CD 			= @[yd_cd]" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("GROUP BY H.GROSS_WORK," ).append("\n"); 
		query.append("H.NET_WORK," ).append("\n"); 
		query.append("H.LOSE_HR," ).append("\n"); 
		query.append("H.GROSS_GANG," ).append("\n"); 
		query.append("H.NET_GANG," ).append("\n"); 
		query.append("H.HATCH," ).append("\n"); 
		query.append("H.CON," ).append("\n"); 
		query.append("H.MVS," ).append("\n"); 
		query.append("H.GROSS_TML," ).append("\n"); 
		query.append("H.NET_TML," ).append("\n"); 
		query.append("H.GROSS_GC," ).append("\n"); 
		query.append("H.NET_GC," ).append("\n"); 
		query.append("H.COMMENCE," ).append("\n"); 
		query.append("H.COMPLETE" ).append("\n"); 

	}
}