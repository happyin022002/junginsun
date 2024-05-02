/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCGExternalFinderDBDAOSearchBkgHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.12.17 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGExternalFinderDBDAOSearchBkgHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 Booking의 Split & Combine History 정보가 가장 최신 정보를 조회한다.
	  * 
	  * * History
	  * * 2012.12.17 진마리아 [CHM-201221863-01] [VOP-SCG] Application Detail for Own BKG 에 combine, split 정보 추가
	  * </pre>
	  */
	public SCGExternalFinderDBDAOSearchBkgHistoryRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration").append("\n"); 
		query.append("FileName : SCGExternalFinderDBDAOSearchBkgHistoryRSQL").append("\n"); 
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
		query.append("SELECT  SUBSTR( COMBINE, INSTR(COMBINE, ':', 1, 1) + 1) BKG_COMBINE," ).append("\n"); 
		query.append("        SUBSTR( SPLIT  , INSTR(SPLIT  , ':', 1, 1) + 1) BKG_SPLIT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  MAX( DECODE( T2.HIS_CATE_NM, 'COMBINE', TO_CHAR(T2.CRE_DT, 'YYYYMMDDHH24MISS')||T2.CRNT_CTNT )) AS COMBINE," ).append("\n"); 
		query.append("                MAX( DECODE( T2.HIS_CATE_NM, 'SPLIT'  , TO_CHAR(T2.CRE_DT, 'YYYYMMDDHH24MISS')||T2.CRNT_CTNT )) AS SPLIT" ).append("\n"); 
		query.append("        FROM    BKG_HIS_MST         T1," ).append("\n"); 
		query.append("                BKG_HIS_DTL         T2," ).append("\n"); 
		query.append("                BKG_HRD_CDG_CTNT    T3" ).append("\n"); 
		query.append("        WHERE   T1.BKG_NO           = T2.BKG_NO" ).append("\n"); 
		query.append("        AND     T1.HIS_SEQ          = T2.HIS_SEQ" ).append("\n"); 
		query.append("        AND     T1.BKG_NO           = @[bkg_no]     --ex) ( 'OSA003872200', 'SZP2D9253500')" ).append("\n"); 
		query.append("        AND     NVL(T1.CORR_NO, 'X') <> 'TMP0000001'" ).append("\n"); 
		query.append("        AND     T2.HIS_CATE_NM      IN ( 'SPLIT', 'COMBINE')" ).append("\n"); 
		query.append("        AND     T3.HRD_CDG_ID       = 'HIST_UI_NAME'" ).append("\n"); 
		query.append("        AND     T3.ATTR_CTNT1       = T1.BKG_HIS_ISS_UI_ID" ).append("\n"); 
		query.append("        AND     T3.ATTR_CTNT1       IN ( 'ESM_BKG_0099', 'ESM_BKG_0076' )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 

	}
}