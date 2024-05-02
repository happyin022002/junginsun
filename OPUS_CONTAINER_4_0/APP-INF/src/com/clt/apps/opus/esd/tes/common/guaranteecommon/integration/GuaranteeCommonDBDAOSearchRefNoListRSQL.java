/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GuaranteeCommonDBDAOSearchRefNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.03.09 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.guaranteecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeCommonDBDAOSearchRefNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guarantee No. 조회
	  * </pre>
	  */
	public GuaranteeCommonDBDAOSearchRefNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.guaranteecommon.integration").append("\n"); 
		query.append("FileName : GuaranteeCommonDBDAOSearchRefNoListRSQL").append("\n"); 
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
		query.append("#if (${cre_flg} == 'G')" ).append("\n"); 
		query.append("-- Guarantee Creation Reference No. PopUp" ).append("\n"); 
		query.append("SELECT	DISTINCT GL.GNTE_NO REF_NO" ).append("\n"); 
		query.append(", GH.DMY_FLG" ).append("\n"); 
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
		query.append(") INV_NO --// TPB와 협의해서 TPB I/F table의 KEY값으로 TPB에서 실제 생성된 TPB INVOICE가 있을 경우 INV_NO를 가져온다." ).append("\n"); 
		query.append("FROM	TES_GNTE_HDR GH" ).append("\n"); 
		query.append(", TES_GNTE_CNTR_LIST GL" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		GH.GNTE_NO = GL.GNTE_NO" ).append("\n"); 
		query.append("AND		NVL(GH.DMY_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("AND		GL.CNTR_NO LIKE '%' || @[cntr_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND		GL.BL_NO LIKE '%' || @[bl_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${cre_flg} != 'G')" ).append("\n"); 
		query.append("-- Irregular Creation Reference No. PopUp" ).append("\n"); 
		query.append("SELECT	DISTINCT IH.IRR_NO REF_NO" ).append("\n"); 
		query.append(", GH.DMY_FLG" ).append("\n"); 
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
		query.append(") INV_NO" ).append("\n"); 
		query.append("FROM	TES_IRR_HDR IH" ).append("\n"); 
		query.append(", TES_GNTE_HDR GH" ).append("\n"); 
		query.append(", TES_GNTE_CNTR_LIST GL" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		IH.GNTE_NO = GH.GNTE_NO" ).append("\n"); 
		query.append("AND		GH.GNTE_NO = GL.GNTE_NO" ).append("\n"); 
		query.append("AND		NVL(GH.DMY_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("AND		GL.CNTR_NO LIKE '%' || @[cntr_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND		GL.BL_NO LIKE '%' || @[bl_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}