/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchTerminalUsingCdCrnNoforHjsVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchTerminalUsingCdCrnNoforHjsVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SML VVD 대상으로 Terminal Operator의 ALPS UI에서 입력받은 Terminal Using Code(or CRN-Ship Calling Number) 조회
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchTerminalUsingCdCrnNoforHjsVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchTerminalUsingCdCrnNoforHjsVvdRSQL").append("\n"); 
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
		query.append("SELECT    	PS.VSL_CD" ).append("\n"); 
		query.append("       ,  	PS.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,  	PS.SKD_DIR_CD" ).append("\n"); 
		query.append("	   ,  	PS.VPS_PORT_CD" ).append("\n"); 
		query.append("FROM      	VSK_VSL_PORT_SKD              	PS" ).append("\n"); 
		query.append("WHERE     	1 = 1" ).append("\n"); 
		query.append("AND			PS.TURN_PORT_IND_CD           	IN ('Y','N')" ).append("\n"); 
		query.append("AND			NVL(PS.SKD_CNG_STS_CD,'*')		<> 'S'" ).append("\n"); 
		query.append("AND			PS.TML_VSL_CD||PS.TML_VOY_NO  	LIKE @[shp_call_no]||'%'" ).append("\n"); 
		query.append("AND			PS.VPS_PORT_CD					= @[vps_port_cd]" ).append("\n"); 
		query.append("AND			PS.YD_CD						= @[yd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("----AND       	PS.VSL_CD	                 	= 	(	SELECT    	MAX(PPS.VSL_CD)" ).append("\n"); 
		query.append("----                                           			FROM      	VSK_VSL_PORT_SKD  				PPS" ).append("\n"); 
		query.append("----                                           			WHERE     	1 = 1" ).append("\n"); 
		query.append("----										    		AND			PPS.TML_VSL_CD||PPS.TML_VOY_NO  LIKE [shp_call_no]||'%'" ).append("\n"); 
		query.append("----                                           		)" ).append("\n"); 
		query.append("----AND     	PS.SKD_VOY_NO||PS.SKD_DIR_CD  	LIKE [edi_skd_voy_no]||'%'" ).append("\n"); 

	}
}