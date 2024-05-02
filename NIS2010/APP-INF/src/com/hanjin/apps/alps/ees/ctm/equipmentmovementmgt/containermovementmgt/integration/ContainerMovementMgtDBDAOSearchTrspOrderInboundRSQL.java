/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchTrspOrderInboundRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.28
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.11.28 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchTrspOrderInboundRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * From Nod VIA_NOD_CD 를 조회한다.
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchTrspOrderInboundRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchTrspOrderInboundRSQL").append("\n"); 
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
		query.append("#if( ${gubun} == '4' ) -- 4 인 경우" ).append("\n"); 
		query.append("	SELECT FM_NOD_CD  AS FM_NOD_CD" ).append("\n"); 
		query.append("         , TO_NOD_CD  AS TO_VIA_NOD_CD " ).append("\n"); 
		query.append("#else -- 1,2,3 인 경우" ).append("\n"); 
		query.append("	SELECT FM_NOD_CD  AS FM_NOD_CD" ).append("\n"); 
		query.append("         , VIA_NOD_CD AS TO_VIA_NOD_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	  FROM TRS_TRSP_SVC_ORD " ).append("\n"); 
		query.append("	 WHERE LOCL_CRE_DT BETWEEN TO_DATE(@[event_date],'YYYYMMDDHH24MI') - 20 " ).append("\n"); 
		query.append("	   AND TO_DATE(@[event_date],'YYYYMMDDHH24MI') + 7 " ).append("\n"); 
		query.append("	   AND TRSP_SO_TP_CD = 'Y' " ).append("\n"); 
		query.append("#if( ${gubun} == '1' || ${gubun} == '2') -- 1,2 인 경우 " ).append("\n"); 
		query.append("	   AND TRSP_COST_DTL_MOD_CD = 'DR' " ).append("\n"); 
		query.append("	   AND ( ( FM_NOD_CD = @[event_yard] AND VIA_NOD_CD IS NULL ) OR ( FM_NOD_CD <> @[event_yard] AND VIA_NOD_CD = @[event_yard]) ) " ).append("\n"); 
		query.append("#elseif( ${gubun} == '3' ) -- 3 인 경우 " ).append("\n"); 
		query.append("	   AND TRSP_COST_DTL_MOD_CD = 'DR' " ).append("\n"); 
		query.append("	   AND ( FM_NOD_CD = @[event_yard] AND VIA_NOD_CD <> @[event_yard] ) " ).append("\n"); 
		query.append("#elseif( ${gubun} == '4' ) -- 4 인 경우" ).append("\n"); 
		query.append("	   AND TRSP_COST_DTL_MOD_CD IN ('LS', 'TS') " ).append("\n"); 
		query.append("	   AND FM_NOD_CD = @[event_yard] AND TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	   AND BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("	   AND EQ_NO  = @[cntr_no]" ).append("\n"); 
		query.append("	   AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("	   AND ROWNUM = 1" ).append("\n"); 

	}
}