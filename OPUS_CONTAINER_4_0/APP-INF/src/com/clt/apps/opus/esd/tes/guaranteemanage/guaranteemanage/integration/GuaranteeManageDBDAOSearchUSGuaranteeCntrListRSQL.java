/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GuaranteeManageDBDAOSearchUSGuaranteeCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.19 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeManageDBDAOSearchUSGuaranteeCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guarantee CNTR 목록 조회
	  * </pre>
	  */
	public GuaranteeManageDBDAOSearchUSGuaranteeCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration").append("\n"); 
		query.append("FileName : GuaranteeManageDBDAOSearchUSGuaranteeCntrListRSQL").append("\n"); 
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
		query.append("GL.GNTE_NO" ).append("\n"); 
		query.append(", GL.TML_GNTE_CNTR_LIST_SEQ" ).append("\n"); 
		query.append(", GL.GNTE_PROC_TP_CD" ).append("\n"); 
		query.append(", CASE	WHEN GL.TML_IF_OFC_CD IS NOT NULL AND GL.TML_IF_SEQ IS NOT NULL" ).append("\n"); 
		query.append("THEN 'I/F'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END CHK_TPB_IF" ).append("\n"); 
		query.append(", CASE	WHEN GL.IRR_NO IS NOT NULL" ).append("\n"); 
		query.append("THEN 'I'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END CHK_IRR" ).append("\n"); 
		query.append(", GL.CNTR_NO" ).append("\n"); 
		query.append(", GL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", GL.BKG_NO" ).append("\n"); 
		query.append(", GL.BKG_NO bkg_no2		-- 원천 Data 비교 위해..." ).append("\n"); 
		query.append(", GL.BKG_NO_LIST_CTNT" ).append("\n"); 
		query.append(", GL.BL_NO" ).append("\n"); 
		query.append(", GL.VVD_CD" ).append("\n"); 
		query.append(", GL.SC_NO" ).append("\n"); 
		query.append(", TO_CHAR(GL.FM_DT, 'YYYY-MM-DD') FM_DT" ).append("\n"); 
		query.append(", TO_CHAR(GL.TO_DT, 'YYYY-MM-DD') TO_DT" ).append("\n"); 
		query.append(", GL.GNTE_AMT" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT	I.N3PTY_INV_NO" ).append("\n"); 
		query.append("FROM	TPB_OTS_DTL D" ).append("\n"); 
		query.append(", TPB_OTS_GRP M" ).append("\n"); 
		query.append(", TPB_INV_RVIS I" ).append("\n"); 
		query.append("WHERE	1   = 1" ).append("\n"); 
		query.append("AND		D.N3PTY_NO		= M.N3PTY_NO" ).append("\n"); 
		query.append("AND		M.N3PTY_INV_NO	= I.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND		I.N3PTY_INV_RVIS_SEQ	= 1" ).append("\n"); 
		query.append("AND		D.N3PTY_EXPN_TP_CD		= 'TES'" ).append("\n"); 
		query.append("AND		N3PTY_IF_TP_CD			= 'S'   -- TPB로 자동으로 넘어온 건" ).append("\n"); 
		query.append("AND		D.MNL_INP_TP_CD			= 'G'" ).append("\n"); 
		query.append("AND		D.IF_OFC_CD		= GL.TML_IF_OFC_CD" ).append("\n"); 
		query.append("AND		D.SRC_IF_SEQ_NO	= GL.TML_IF_SEQ" ).append("\n"); 
		query.append(") TPB_INV_NO --// TPB와 협의해서 TPB I/F table의 KEY값으로 TPB에서 실제 생성된 TPB INVOICE가 있을 경우 INV_NO를 가져온다." ).append("\n"); 
		query.append(", GL.TML_IF_OFC_CD" ).append("\n"); 
		query.append(", GL.TML_IF_SEQ" ).append("\n"); 
		query.append(", GL.IRR_NO" ).append("\n"); 
		query.append("FROM	TES_GNTE_HDR GH" ).append("\n"); 
		query.append(", TES_GNTE_CNTR_LIST GL" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		NVL(GH.DMY_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND		GH.GNTE_NO	= GL.GNTE_NO" ).append("\n"); 
		query.append("AND		GH.GNTE_NO	= @[gnte_no]" ).append("\n"); 
		query.append("ORDER BY GH.GNTE_NO, GL.TML_GNTE_CNTR_LIST_SEQ" ).append("\n"); 

	}
}