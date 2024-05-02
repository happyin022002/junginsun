/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrHeaderAvgGangVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTdrHeaderAvgGangVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TerminalDepartureReportDBDAOTdrHeaderAvgGangVO
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrHeaderAvgGangVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_sys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_ind",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrHeaderAvgGangVOUSQL").append("\n"); 
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
		query.append("UPDATE TDR_HEADER SET" ).append("\n"); 
		query.append("		UPDATE_SYS = @[update_sys]" ).append("\n"); 
		query.append(",		UPDATE_USER = @[update_user]" ).append("\n"); 
		query.append(",		UPDATE_TIME = SYSDATE" ).append("\n"); 
		query.append(",   	UPD_SYS_CD = 'N'" ).append("\n"); 
		query.append(",       AVG_GANG = (SELECT " ).append("\n"); 
		query.append("							ROUND((H.MVS / (DECODE(TO_NUMBER(SUBSTR(H.GROSS_WORK,1,INSTR(H.GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(H.GROSS_WORK,INSTR(H.GROSS_WORK,':')+1)/60),0,1," ).append("\n"); 
		query.append("							TO_NUMBER(SUBSTR(H.GROSS_WORK,1,INSTR(H.GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(H.GROSS_WORK,INSTR(H.GROSS_WORK,':')+1)/60)))) /" ).append("\n"); 
		query.append("							DECODE(H.MVS / (DECODE(TO_NUMBER(SUBSTR(H.GROSS_GANG,1,INSTR(H.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(H.GROSS_GANG,INSTR(H.GROSS_GANG,':')+1)/60),0,1," ).append("\n"); 
		query.append("							TO_NUMBER(SUBSTR(H.GROSS_GANG,1,INSTR(H.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(H.GROSS_GANG,INSTR(H.GROSS_GANG,':')+1)/60))),0,1," ).append("\n"); 
		query.append("							(H.MVS / (DECODE(TO_NUMBER(SUBSTR(H.GROSS_GANG,1,INSTR(H.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(H.GROSS_GANG,INSTR(H.GROSS_GANG,':')+1)/60),0,1," ).append("\n"); 
		query.append("							TO_NUMBER(SUBSTR(H.GROSS_GANG,1,INSTR(H.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(H.GROSS_GANG,INSTR(H.GROSS_GANG,':')+1)/60))))),2) as AVG_CRANE" ).append("\n"); 
		query.append("					FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H" ).append("\n"); 
		query.append("					WHERE  V.VSL_CD   		= H.VSL_CD" ).append("\n"); 
		query.append("					AND    V.SKD_VOY_NO   	= H.VOY_NO" ).append("\n"); 
		query.append("					AND    V.SKD_DIR_CD   	= H.DIR_CD" ).append("\n"); 
		query.append("					AND    V.VPS_PORT_CD  	= H.PORT_CD" ).append("\n"); 
		query.append("					AND    V.CLPT_IND_SEQ 	= H.CALL_IND" ).append("\n"); 
		query.append("					AND    V.VSL_CD  		= @[vsl_cd]" ).append("\n"); 
		query.append("					AND    V.SKD_VOY_NO  	= @[voy_no]" ).append("\n"); 
		query.append("					AND    V.SKD_DIR_CD  	= @[dir_cd]" ).append("\n"); 
		query.append("					AND    V.YD_CD 			= @[tml_cd]" ).append("\n"); 
		query.append("					AND    V.CLPT_IND_SEQ   = @[call_ind]" ).append("\n"); 
		query.append("					GROUP BY H.GROSS_WORK," ).append("\n"); 
		query.append("							H.NET_WORK," ).append("\n"); 
		query.append("							H.LOSE_HR," ).append("\n"); 
		query.append("							H.GROSS_GANG," ).append("\n"); 
		query.append("							H.NET_GANG," ).append("\n"); 
		query.append("							H.HATCH," ).append("\n"); 
		query.append("							H.CON," ).append("\n"); 
		query.append("							H.MVS," ).append("\n"); 
		query.append("							H.GROSS_TML," ).append("\n"); 
		query.append("							H.NET_TML," ).append("\n"); 
		query.append("							H.GROSS_GC," ).append("\n"); 
		query.append("							H.NET_GC," ).append("\n"); 
		query.append("							H.COMMENCE," ).append("\n"); 
		query.append("							H.COMPLETE" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND	DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND	PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND	CALL_IND = @[call_ind]" ).append("\n"); 

	}
}