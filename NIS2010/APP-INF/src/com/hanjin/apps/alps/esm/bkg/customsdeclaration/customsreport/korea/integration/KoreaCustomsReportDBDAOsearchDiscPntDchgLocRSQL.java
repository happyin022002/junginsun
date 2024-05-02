/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchDiscPntDchgLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.25 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchDiscPntDchgLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 하선장소, Bonded W/H, Bonded Type조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchDiscPntDchgLocRSQL(){
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
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration ").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOsearchDiscPntDchgLocRSQL").append("\n"); 
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
		query.append("SELECT NVL(MF_SEQ_NO,' ') MF_SEQ_NO" ).append("\n"); 
		query.append(", NVL(KR_CSTMS_BL_TP_CD,' ') KR_CSTMS_BL_TP_CD" ).append("\n"); 
		query.append(", NVL(MRN_BL_TS_CD,' ') MRN_BL_TS_CD" ).append("\n"); 
		query.append(", NVL(CSTMS_CLR_TP_CD,' ')||NVL(CSTMS_DCHG_LOC_WH_CD,' ') CSTMS_DCHG_LOC_WH_CD /** 하선장소 **/" ).append("\n"); 
		query.append(", NVL(CSTMS_CLR_LOC_CD,' ') CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append(", NVL(CSTMS_CLR_WH_CD,' ') BONDED_WH /** BONDED W/H **/" ).append("\n"); 
		query.append(", NVL(SUBSTR(WH.WH_NM, 1, 20),' ') BONDED_TP /** BONDED TYPE **/" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_MF_SEQ_NO MSN, BKG_WAREHOUSE WH" ).append("\n"); 
		query.append("WHERE BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("AND MF_REF_NO = @[mrn_no]" ).append("\n"); 
		query.append("AND WH.CNT_CD(+) = 'KR'" ).append("\n"); 
		query.append("AND MSN.CSTMS_CLR_WH_CD = WH.CSTMS_CD(+)" ).append("\n"); 

	}
}