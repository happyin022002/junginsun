/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchYdInfoByEdoTransRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchYdInfoByEdoTransRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Container 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchYdInfoByEdoTransRSQLRSQL(){
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
		params.put("mf_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchYdInfoByEdoTransRSQLRSQL").append("\n"); 
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
		query.append("SELECT DECODE( CSTMS_CLR_WH_CD, '0000000004', CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append(", '0000000012', CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append(", '0000000018', CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append(", '0000000014', CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append(", '0000000017', CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append(", '0000000006', CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append(", '0000000003', CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append(", CSTMS_CLR_WH_CD) AS DISC_LOC2 -- DISC_LOC2" ).append("\n"); 
		query.append(", CSTMS_DCHG_LOC_WH_CD AS DISC_LOC1                      -- DISC_LOC1" ).append("\n"); 
		query.append(", KR_CSTMS_BL_TP_CD    AS BL_TP                          -- BL_TP" ).append("\n"); 
		query.append(", BD_TP_CD             AS BND_TP                         -- BND_TP" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_MF_SEQ_NO" ).append("\n"); 
		query.append("WHERE BKG_NO 	  = @[bkg_no]" ).append("\n"); 
		query.append("AND MF_REF_NO  = SUBSTR(@[mf_ref_no], 1, 10)" ).append("\n"); 
		query.append("AND MRN_CHK_NO = SUBSTR(@[mf_ref_no], 11, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- CSTMS_DCHG_LOC_WH_CD 컬럼 변경 USA_YD_CD" ).append("\n"); 
		query.append("-- KT-NET 에서 배정장소가 없으면 발급 대기상태로 하기 때문에" ).append("\n"); 
		query.append("-- 부두직통관(C), 입항전 신고(A), 차상반출(B), 내장통관(J) 4가지의 경우에" ).append("\n"); 
		query.append("-- 하선장소를 배정장소에 자동 기입하기 위하여 Bonded Type 조회" ).append("\n"); 

	}
}