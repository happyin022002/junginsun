/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExtraDisposalMgtDBDAOsearchExtraDisposalListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.03.02 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExtraDisposalMgtDBDAOsearchExtraDisposalListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Scrapping/Donation Inquiry 에서 조회
	  * </pre>
	  */
	public ExtraDisposalMgtDBDAOsearchExtraDisposalListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_xtra_disp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.integration").append("\n"); 
		query.append("FileName : ExtraDisposalMgtDBDAOsearchExtraDisposalListDataRSQL").append("\n"); 
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
		query.append("SELECT A.XTRA_DISP_SEQ" ).append("\n"); 
		query.append(",A.EQ_KND_CD" ).append("\n"); 
		query.append(",A.EQ_NO" ).append("\n"); 
		query.append(",A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",A.XTRA_DISP_STS_CD" ).append("\n"); 
		query.append(",A.MNR_XTRA_DISP_TP_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.XTRA_DISP_EXPN_AMT" ).append("\n"); 
		query.append(",A.XTRA_DISP_INCM_AMT" ).append("\n"); 
		query.append(",TO_CHAR(A.ISS_DT, 'yyyy-mm-dd') ISS_DT" ).append("\n"); 
		query.append(",A.ISS_OFC_CD" ).append("\n"); 
		query.append(",A.ISS_YD_CD" ).append("\n"); 
		query.append(",A.XTRA_DISP_DESC" ).append("\n"); 
		query.append(",A.XTRA_DISP_RMK" ).append("\n"); 
		query.append(",A.FILE_SEQ" ).append("\n"); 
		query.append(",A.IF_TRC_SEQ" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_XTRA_DISP A" ).append("\n"); 
		query.append("WHERE A.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[cre_dt_fr],'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[cre_dt_to]||'23:59:59','YYYY-MM-DD HH24:MI:SS'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnr_xtra_disp_tp_cd} != 'A')" ).append("\n"); 
		query.append("AND A.MNR_XTRA_DISP_TP_CD = @[mnr_xtra_disp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_knd_cd} != 'A')" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_no} != '')" ).append("\n"); 
		query.append("AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${iss_ofc_cd} != '' && ${iss_ofc_cd} != 'A')" ).append("\n"); 
		query.append("AND A.ISS_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}