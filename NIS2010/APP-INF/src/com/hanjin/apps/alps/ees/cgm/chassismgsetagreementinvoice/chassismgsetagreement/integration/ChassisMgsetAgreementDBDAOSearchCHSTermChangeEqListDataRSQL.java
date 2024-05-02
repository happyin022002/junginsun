/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchCHSTermChangeEqListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.10.30 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOSearchCHSTermChangeEqListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.SearchCHSTermChangeEqListData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchCHSTermChangeEqListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchCHSTermChangeEqListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("B.EQ_NO," ).append("\n"); 
		query.append("B.EQ_TPSZ_CD," ).append("\n"); 
		query.append("B.AGMT_LSTM_CD," ).append("\n"); 
		query.append("B.ONH_OFC_CD AS STS_EVNT_OFC_CD," ).append("\n"); 
		query.append("B.CRNT_YD_CD AS STS_EVNT_YD_CD," ).append("\n"); 
		query.append("B.CRNT_LOC_CD AS STS_EVNT_LOC_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("A.AGMT_VER_NO," ).append("\n"); 
		query.append("A.AGMT_REF_NO," ).append("\n"); 
		query.append("B.ACIAC_DIV_CD," ).append("\n"); 
		query.append("C.EQ_ASET_STS_CD," ).append("\n"); 
		query.append("TO_Char(C.STS_EVNT_DT,'YYYYMMDD') STS_EVNT_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_AGREEMENT A," ).append("\n"); 
		query.append("CGM_EQUIPMENT B," ).append("\n"); 
		query.append("CGM_EQ_STS_HIS C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND B.EQ_NO = C.EQ_NO" ).append("\n"); 
		query.append("AND C.EQ_STS_SEQ = (SELECT MAX(EQ_STS_SEQ) FROM CGM_EQ_STS_HIS" ).append("\n"); 
		query.append("WHERE EQ_NO = C.EQ_NO)" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND B.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND C.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY B.EQ_NO" ).append("\n"); 

	}
}