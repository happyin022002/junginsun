/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffMgtDBDAOaddDisposalTariffRegionInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.16
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.09.16 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOaddDisposalTariffRegionInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기별 매각기준 가격정보를 개별 생성합니다.
	  * </pre>
	  */
	public TariffMgtDBDAOaddDisposalTariffRegionInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insert_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_trf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_trf_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_eff_qtr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_eff_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOaddDisposalTariffRegionInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_DISP_TRF (" ).append("\n"); 
		query.append("    TRF_EFF_YR, " ).append("\n"); 
		query.append("	TRF_EFF_QTR_NO, " ).append("\n"); 
		query.append("	MNR_DISP_TRF_SEQ, " ).append("\n"); 
		query.append("	EQ_KND_CD, " ).append("\n"); 
		query.append("	EQ_TPSZ_CD, " ).append("\n"); 
		query.append("	LOC_CD, " ).append("\n"); 
		query.append("	CURR_CD, " ).append("\n"); 
		query.append("	MNR_DISP_TRF_AMT, " ).append("\n"); 
		query.append("	MNR_TRF_RMK, " ).append("\n"); 
		query.append("	CRE_OFC_CD, " ).append("\n"); 
		query.append("	CRE_USR_ID, " ).append("\n"); 
		query.append("	CRE_DT, " ).append("\n"); 
		query.append("	UPD_USR_ID, " ).append("\n"); 
		query.append("	UPD_DT " ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[trf_eff_yr], " ).append("\n"); 
		query.append("	@[trf_eff_qtr_no], " ).append("\n"); 
		query.append("    (SELECT  NVL(MAX(MNR_DISP_TRF_SEQ), 0) +1+@[insert_seq]" ).append("\n"); 
		query.append("	 FROM    MNR_DISP_TRF" ).append("\n"); 
		query.append("	 WHERE   TRF_EFF_YR = @[trf_eff_yr]" ).append("\n"); 
		query.append("	 AND     TRF_EFF_QTR_NO = @[trf_eff_qtr_no]), " ).append("\n"); 
		query.append("    @[eq_knd_cd]," ).append("\n"); 
		query.append("    @[eq_tpsz_cd]," ).append("\n"); 
		query.append("    @[loc_cd]," ).append("\n"); 
		query.append("    @[curr_cd]," ).append("\n"); 
		query.append("    @[mnr_disp_trf_amt]," ).append("\n"); 
		query.append("    @[mnr_trf_rmk]," ).append("\n"); 
		query.append("    @[cre_ofc_cd]," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}