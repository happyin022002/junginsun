/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchTrspOrderOutboundbyGBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : 강환
*@LastVersion : 1.0
* 2014.03.11 강환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwan, Kang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchTrspOrderOutboundbyGBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (조건)
	  *  1) OP MVMT 이후 MT/TN(EN) 
	  *  2) County : GB
	  *  3) MT gate-in/out yard가 S/O의 via yard와 동일하고, F/M가 "M"이면
	  * 
	  *  (결과)
	  *  1) MT/TN은 오류처리
	  *  4) 오류 msg내용: Unnecessary MT/TN(EN) due to S/O via yard
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchTrspOrderOutboundbyGBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchTrspOrderOutboundbyGBRSQL").append("\n"); 
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
		query.append("SELECT FM_NOD_CD  AS FM_NOD_CD" ).append("\n"); 
		query.append("         , VIA_NOD_CD AS TO_VIA_NOD_CD " ).append("\n"); 
		query.append("	  FROM TRS_TRSP_SVC_ORD " ).append("\n"); 
		query.append("	 WHERE LOCL_CRE_DT BETWEEN TO_DATE(@[event_date],'YYYYMMDDHH24MI') - 20 " ).append("\n"); 
		query.append("	   AND TO_DATE(@[event_date],'YYYYMMDDHH24MI') + 7 " ).append("\n"); 
		query.append("	   AND TRSP_SO_TP_CD = 'Y' " ).append("\n"); 
		query.append("	   AND FM_NOD_CD <> @[event_yard] AND VIA_NOD_CD = @[event_yard]" ).append("\n"); 
		query.append(" 	   AND BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("	   AND TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("	   AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("	   AND ROWNUM = 1" ).append("\n"); 

	}
}