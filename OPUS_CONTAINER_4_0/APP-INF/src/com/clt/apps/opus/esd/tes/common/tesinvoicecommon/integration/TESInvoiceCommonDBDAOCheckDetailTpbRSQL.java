/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOCheckDetailTpbRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.05 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInvoiceCommonDBDAOCheckDetailTpbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * N3RT_PTY_IF 존재 여부 Check
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOCheckDetailTpbRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration ").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOCheckDetailTpbRSQL").append("\n"); 
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
		query.append("SELECT	D.TML_SO_OFC_CTY_CD	AS SO_OFC_CD" ).append("\n"); 
		query.append(", D.TML_SO_SEQ		AS SO_SEQ" ).append("\n"); 
		query.append(", D.TML_SO_DTL_SEQ    AS DTL_SEQ" ).append("\n"); 
		query.append(", D.LGS_COST_CD" ).append("\n"); 
		query.append(", D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", N3PTY_FLG" ).append("\n"); 
		query.append(", COUNT(TML_IF_SEQ)	AS CNT" ).append("\n"); 
		query.append("FROM	TES_TML_SO_DTL D" ).append("\n"); 
		query.append(", TES_N3RD_PTY_IF T" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		D.TML_SO_OFC_CTY_CD	= T.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND		D.TML_SO_SEQ		= T.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("AND		D.TML_SO_DTL_SEQ	= T.TML_SO_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND		D.TML_SO_OFC_CTY_CD	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND		D.TML_SO_SEQ		= @[tml_so_seq]" ).append("\n"); 
		query.append("GROUP BY D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", D.TML_SO_SEQ" ).append("\n"); 
		query.append(", D.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append(", N3PTY_FLG" ).append("\n"); 
		query.append(", D.LGS_COST_CD" ).append("\n"); 
		query.append(", D.CNTR_TPSZ_CD" ).append("\n"); 

	}
}