/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchCheckRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.29
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.03.29 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchCheckRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CY code 수정 시 Bkg 정보가 있는 지 Check 하는 쿼리
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchCheckRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchCheckRouteRSQL").append("\n"); 
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
		query.append("SELECT 'Y' as OUTPUT_TEXT  " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND EXISTS (SELECT * FROM BKG_VVD V, BKG_BOOKING B" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND B.BKG_NO=V.BKG_NO" ).append("\n"); 
		query.append("                AND B.POL_CD=V.POL_CD" ).append("\n"); 
		query.append("                AND V.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("                AND V.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("                AND V.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("                AND B.POL_CD=@[pol_cd]" ).append("\n"); 
		query.append("                AND V.POL_YD_CD=@[pol_yd_cd]" ).append("\n"); 
		query.append("                AND B.POR_CD=@[por_cd]" ).append("\n"); 
		query.append("			#if (${por_yd_cd} != '') " ).append("\n"); 
		query.append("                AND B.POR_NOD_CD=@[por_yd_cd]" ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("				AND B.POR_NOD_CD IS NULL" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append(" 				AND rownum =1" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}