/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IrregularManageDBDAOSearchIrregularCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IrregularManageDBDAOSearchIrregularCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Irregular Container List 조회
	  * </pre>
	  */
	public IrregularManageDBDAOSearchIrregularCntrListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.integration").append("\n"); 
		query.append("FileName : IrregularManageDBDAOSearchIrregularCntrListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		  IH.IRR_NO" ).append("\n"); 
		query.append("		, GH.GNTE_NO" ).append("\n"); 
		query.append("		, GL.TML_GNTE_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("		, CASE	WHEN GL.TML_IF_OFC_CD IS NOT NULL " ).append("\n"); 
		query.append("					AND GL.TML_IF_SEQ IS NOT NULL " ).append("\n"); 
		query.append("					AND	NVL(GL.IRR_NO_IF_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("				THEN 'I/F'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("		END CHK_TPB_IF" ).append("\n"); 
		query.append("		, GL.CNTR_NO" ).append("\n"); 
		query.append("		, GL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, GL.BKG_NO" ).append("\n"); 
		query.append("		, GL.BKG_NO bkg_no2		-- 원천 Data 비교 위해..." ).append("\n"); 
		query.append("		, 'N/A|'||GL.BKG_NO_LIST_CTNT BKG_NO_LIST_CTNT" ).append("\n"); 
		query.append("		, GL.BL_NO" ).append("\n"); 
		query.append("		, GL.SC_NO" ).append("\n"); 
		query.append("		, GL.VVD_CD" ).append("\n"); 
		query.append("		, TO_CHAR(GL.FM_DT, 'YYYY-MM-DD') FM_DT" ).append("\n"); 
		query.append("		, TO_CHAR(GL.TO_DT, 'YYYY-MM-DD') TO_DT" ).append("\n"); 
		query.append("		, GL.TML_IF_OFC_CD" ).append("\n"); 
		query.append("		, GL.TML_IF_SEQ" ).append("\n"); 
		query.append("		, GL.GNTE_AMT" ).append("\n"); 
		query.append("FROM	TES_IRR_HDR IH" ).append("\n"); 
		query.append("		, TES_GNTE_HDR GH" ).append("\n"); 
		query.append("		, TES_GNTE_CNTR_LIST GL" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		IH.GNTE_NO	= GH.GNTE_NO" ).append("\n"); 
		query.append("AND		GH.GNTE_NO	= GL.GNTE_NO" ).append("\n"); 
		query.append("AND		IH.IRR_NO	= GL.IRR_NO" ).append("\n"); 
		query.append("#if (${irr_no} != '') " ).append("\n"); 
		query.append("AND		IH.IRR_NO	= @[irr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gnte_no} != '') " ).append("\n"); 
		query.append("AND		IH.GNTE_NO	= @[gnte_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     GL.GNTE_PROC_TP_CD = 'I'" ).append("\n"); 
		query.append("--AND		NVL(GH.DMY_FLG, 'N') = 'Y'" ).append("\n"); 

	}
}