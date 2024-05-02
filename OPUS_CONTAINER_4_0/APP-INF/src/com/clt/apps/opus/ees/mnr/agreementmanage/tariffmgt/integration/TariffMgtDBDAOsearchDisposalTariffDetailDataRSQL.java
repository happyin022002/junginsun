/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffMgtDBDAOsearchDisposalTariffDetailDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.04.07 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOsearchDisposalTariffDetailDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public TariffMgtDBDAOsearchDisposalTariffDetailDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_disp_trf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_trf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOsearchDisposalTariffDetailDataRSQL").append("\n"); 
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
		query.append("A.MNR_DISP_TRF_SEQ" ).append("\n"); 
		query.append(",A.MNR_DISP_TRF_DTL_SEQ" ).append("\n"); 
		query.append(",A.MNR_DISP_TRF_GRP_CD" ).append("\n"); 
		query.append(",A.CTRL_OFC_CD" ).append("\n"); 
		query.append(",A.LOC_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",A.MNR_DISP_TRF_AMT" ).append("\n"); 
		query.append(",A.MNR_VRFY_TP_CD" ).append("\n"); 
		query.append(",A.DTL_RMK" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append(",TO_CHAR(B.EFF_DT, 'yyyy-mm-dd') EFF_DT" ).append("\n"); 
		query.append(",B.MNR_DISP_TRF_STS_CD" ).append("\n"); 
		query.append(",DECODE(B.MNR_DISP_TRF_STS_CD,'S','Save','C','Confirm','New') AS MNR_DISP_TRF_STS_NM" ).append("\n"); 
		query.append(",B.MNR_DISP_TRF_TP_CD" ).append("\n"); 
		query.append("FROM MNR_DISP_TRF_DTL A,  MNR_DISP_TRF_HDR B" ).append("\n"); 
		query.append("WHERE A.MNR_DISP_TRF_SEQ = B.MNR_DISP_TRF_SEQ" ).append("\n"); 
		query.append("AND B.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if(${mnr_disp_trf_seq} != '')" ).append("\n"); 
		query.append("AND A.MNR_DISP_TRF_SEQ = @[mnr_disp_trf_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${mnr_disp_trf_grp_cd} != '')" ).append("\n"); 
		query.append("AND A.MNR_DISP_TRF_GRP_CD = @[mnr_disp_trf_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnr_disp_trf_tp_cd} != '')" ).append("\n"); 
		query.append("AND B.MNR_DISP_TRF_TP_CD = @[mnr_disp_trf_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_disp_trf_seq} != '')" ).append("\n"); 
		query.append("AND B.MNR_DISP_TRF_SEQ = @[mnr_disp_trf_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eff_dt} != '')" ).append("\n"); 
		query.append("AND B.EFF_DT = TO_DATE(@[eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.MNR_DISP_TRF_SEQ,A.MNR_DISP_TRF_DTL_SEQ,A.MNR_DISP_TRF_GRP_CD,A.LOC_CD,A.CURR_CD,A.EQ_TPSZ_CD" ).append("\n"); 

	}
}