/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommDBDAOBasicInformationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.04.19 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommDBDAOBasicInformationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0001 화면 Basic Information 조회
	  * </pre>
	  */
	public AGTCommDBDAOBasicInformationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTCommDBDAOBasicInformationVORSQL").append("\n"); 
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
		query.append("X.BL_NO AS BL_NO," ).append("\n"); 
		query.append("X.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("Y.VENDOR," ).append("\n"); 
		query.append("Y.AGN_AGMT_NO AS AGMT_NO," ).append("\n"); 
		query.append("Y.AGN_CD AS AGN_CD," ).append("\n"); 
		query.append("X.TRK_VVD AS TRK_VVD," ).append("\n"); 
		query.append("X.TRK_SLANE AS TRK_SLANE," ).append("\n"); 
		query.append("Y.FDR_VVD AS FDR_VVD," ).append("\n"); 
		query.append("X.SC_NO AS SC_NO," ).append("\n"); 
		query.append("X.RFA_NO AS RFA_NO," ).append("\n"); 
		query.append("X.SVC_SCP SVC_SCP," ).append("\n"); 
		query.append("X.POR," ).append("\n"); 
		query.append("X.POL," ).append("\n"); 
		query.append("X.PRE," ).append("\n"); 
		query.append("X.POST," ).append("\n"); 
		query.append("X.POD," ).append("\n"); 
		query.append("X.DEL," ).append("\n"); 
		query.append("X.GROSS," ).append("\n"); 
		query.append("X.OFT_PPD AS OFT_PPD," ).append("\n"); 
		query.append("X.OFT_CCT AS OFT_CCT," ).append("\n"); 
		query.append("X.CHARGE_PPD AS CHARGE_PPD," ).append("\n"); 
		query.append("X.CHARGE_CCT AS CHARGE_CCT" ).append("\n"); 
		query.append("FROM (SELECT" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("BL_NO," ).append("\n"); 
		query.append("TRNK_VSL_CD||TRNK_SKD_VOY_NO||TRNK_SKD_DIR_CD||TRNK_REV_DIR_CD TRK_VVD," ).append("\n"); 
		query.append("TRNK_SLAN_CD	TRK_SLANE, NVL(SC_NO, '	') SC_NO," ).append("\n"); 
		query.append("NVL(RFA_NO, ' ')	RFA_NO,	NVL(SVC_SCP_CD,	' ') SVC_SCP," ).append("\n"); 
		query.append("BKG_POR_CD POR, BKG_POL_CD POL, BKG_POD_CD POD, BKG_DEL_CD DEL," ).append("\n"); 
		query.append("PRE_PORT_CD PRE,	PST_PORT_CD	POST," ).append("\n"); 
		query.append("TO_CHAR(NVL(BKG_PPD_FRT_AMT,0) +	NVL(BKG_PPD_OTR_AMT,0) + NVL(BKG_CLT_FRT_AMT,0)	+ NVL(BKG_CLT_OTR_AMT,0),'999,999,990.00') GROSS," ).append("\n"); 
		query.append("TO_CHAR(NVL(BKG_PPD_FRT_AMT,0),'999,999,990.00')	OFT_PPD," ).append("\n"); 
		query.append("TO_CHAR(NVL(BKG_CLT_FRT_AMT,0),'999,999,990.00')	OFT_CCT," ).append("\n"); 
		query.append("TO_CHAR(NVL(BKG_PPD_OTR_AMT,0),'999,999,990.00')	CHARGE_PPD," ).append("\n"); 
		query.append("TO_CHAR(NVL(BKG_CLT_OTR_AMT,0),'999,999,990.00')	CHARGE_CCT" ).append("\n"); 
		query.append("FROM AGT_COMM_BKG_INFO" ).append("\n"); 
		query.append("WHERE BKG_NO =	@[bkg_no]" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("DISTINCT	A.BKG_NO," ).append("\n"); 
		query.append("A.COMM_VSL_CD||A.COMM_SKD_VOY_NO||A.COMM_SKD_DIR_CD||A.COMM_REV_DIR_CD FDR_VVD," ).append("\n"); 
		query.append("A.AGN_AGMT_NO, A.AGN_CD,	TO_CHAR(A.VNDR_SEQ,'FM000000') VENDOR" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM	A" ).append("\n"); 
		query.append("WHERE A.BKG_NO	= @[bkg_no]" ).append("\n"); 
		query.append("AND A.AGN_CD	= @[agn_cd]" ).append("\n"); 
		query.append("AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD	<> 'T'" ).append("\n"); 
		query.append("AND A.AC_SEQ	= @[ac_seq]" ).append("\n"); 
		query.append("AND (A.BKG_NO, A.AGN_CD,	A.IO_BND_CD, A.AC_TP_CD, A.AC_SEQ) IN" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("AGN_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("MAX(AC_SEQ)" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO =	A.BKG_NO" ).append("\n"); 
		query.append("AND AGN_CD =	A.AGN_CD" ).append("\n"); 
		query.append("AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("AND AC_TP_CD	= A.AC_TP_CD" ).append("\n"); 
		query.append("AND AC_SEQ =	A.AC_SEQ" ).append("\n"); 
		query.append("GROUP BY BKG_NO, AGN_CD, IO_BND_CD, AC_TP_CD)" ).append("\n"); 
		query.append("AND ROWNUM =	1" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE X.BKG_NO	= Y.BKG_NO" ).append("\n"); 

	}
}