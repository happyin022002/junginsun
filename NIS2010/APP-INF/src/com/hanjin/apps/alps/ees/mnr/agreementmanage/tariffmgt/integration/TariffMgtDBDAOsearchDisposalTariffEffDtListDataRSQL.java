/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffMgtDBDAOsearchDisposalTariffEffDtListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOsearchDisposalTariffEffDtListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public TariffMgtDBDAOsearchDisposalTariffEffDtListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOsearchDisposalTariffEffDtListDataRSQL").append("\n"); 
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
		query.append(",TO_CHAR(A.EFF_DT, 'yyyy-mm-dd') EFF_DT" ).append("\n"); 
		query.append(",A.EQ_KND_CD" ).append("\n"); 
		query.append(",A.MNR_DISP_TRF_TP_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD B" ).append("\n"); 
		query.append("WHERE B.PRNT_CD_ID = 'CD00047'" ).append("\n"); 
		query.append("AND B.MNR_CD_ID =A.MNR_DISP_TRF_TP_CD" ).append("\n"); 
		query.append(") AS MNR_DISP_TRF_TP_NM" ).append("\n"); 
		query.append(",A.MNR_INP_TP_CD" ).append("\n"); 
		query.append(",A.MNR_DISP_TRF_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.MNR_DISP_TRF_STS_DT, 'yyyy-mm-dd') MNR_DISP_TRF_STS_DT" ).append("\n"); 
		query.append(",A.MNR_TRF_RMK" ).append("\n"); 
		query.append(",A.MNR_DISP_TRF_LST_VER_FLG" ).append("\n"); 
		query.append(",A.CRE_OFC_CD" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_DISP_TRF_HDR A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("ORDER BY A.EFF_DT DESC" ).append("\n"); 

	}
}