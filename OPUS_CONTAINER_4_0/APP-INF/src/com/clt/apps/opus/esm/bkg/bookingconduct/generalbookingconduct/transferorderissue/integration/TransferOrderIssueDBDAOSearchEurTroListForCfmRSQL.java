/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchEurTroListForCfmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchEurTroListForCfmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchEurTroListForCfmRSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchEurTroListForCfmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchEurTroListForCfmRSQL").append("\n"); 
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
		query.append("SELECT MST.TRO_SEQ" ).append("\n"); 
		query.append(", LPAD(MST.TRO_SEQ, 3, '0') TRO_SEQ_DISP" ).append("\n"); 
		query.append(", MST.CNTR_NO" ).append("\n"); 
		query.append(", DECODE(CFM_FLG, 'Y', 'Yes', 'No') CFM_FLG" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", CORR_NO" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(NMF_TRNS_REV_AMT, '999,999,999.99')) TRNS_REV_AMT" ).append("\n"); 
		query.append("--, DECODE(ALL_IN_RT_FLG, 'Y', 'Yes', 'No') ALL_IN_RT_FLG" ).append("\n"); 
		query.append(", DECODE(ALL_IN_RT_CD, 'Y', 'Yes', 'No') ALL_IN_RT_CD" ).append("\n"); 
		query.append(", DECODE(T1_DOC_FLG, 'Y', 'Yes', 'No') T1_DOC_FLG" ).append("\n"); 
		query.append(", DECODE(VAT_FLG, 'Y', 'Yes', 'No') VAT_FLG" ).append("\n"); 
		query.append(", CXL_FLG" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", HLG_TP_CD" ).append("\n"); 
		query.append(", CFM_DT" ).append("\n"); 
		query.append(", '' PAYER_CNT_CD" ).append("\n"); 
		query.append(", '' PAYER_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", DECODE(CFM_FLG, 'Y', 'Yes', 'No') CFM_FLG_OLD" ).append("\n"); 
		query.append(", BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append(", CNTR_PKUP_YD_CD" ).append("\n"); 
		query.append(", CNTR_RTN_YD_CD" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("#if (${io_bnd_cd} == 'I')" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(TRODTL XPKBKG_EUR_TRO_DTL) */ ZN_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT /*+ INDEX(TRODTL XPKBKG_EUR_TRO_DTL) */ ZN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO_DTL" ).append("\n"); 
		query.append("WHERE BKG_NO    = MST.BKG_NO" ).append("\n"); 
		query.append("AND IO_BND_CD = MST.IO_BND_CD" ).append("\n"); 
		query.append("AND TRO_SEQ   = MST.TRO_SEQ" ).append("\n"); 
		query.append("AND ROWNUM    = 1 ) ZN_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(ADD_REV_AMT, '999,999,999.99')) ADD_REV_AMT" ).append("\n"); 
		query.append(", ADD_REV_CHG_CD" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO MST" ).append("\n"); 
		query.append("WHERE MST.BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("AND MST.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("and mst.cxl_flg = 'N'" ).append("\n"); 

	}
}