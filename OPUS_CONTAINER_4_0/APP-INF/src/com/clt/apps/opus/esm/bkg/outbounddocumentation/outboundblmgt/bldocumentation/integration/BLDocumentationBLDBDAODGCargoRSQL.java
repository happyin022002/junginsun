/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAODGCargoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.30 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAODGCargoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Select
	  * </pre>
	  */
	public BLDocumentationBLDBDAODGCargoRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT   OUT_IMDG_PCK_QTY1 PCK_QTY" ).append("\n");
		query.append(",        OUT_IMDG_PCK_CD1 PCK_TP_CD" ).append("\n");
		query.append(",        (SELECT   SUBSTR (IMDG_PCK_DESC" ).append("\n");
		query.append(",                1" ).append("\n");
		query.append(",                DECODE (INSTR (IMDG_PCK_DESC, ',', INSTR (IMDG_PCK_DESC, ',') + 1)" ).append("\n");
		query.append(",                        0, LENGTH (IMDG_PCK_DESC)" ).append("\n");
		query.append(",                        INSTR (IMDG_PCK_DESC, ',', INSTR (IMDG_PCK_DESC, ',') + 1) - 1" ).append("\n");
		query.append(")" ).append("\n");
		query.append(")" ).append("\n");
		query.append("FROM     SCG_IMDG_PCK_CD" ).append("\n");
		query.append("WHERE    IMDG_PCK_CD = A.OUT_IMDG_PCK_CD1" ).append("\n");
		query.append(") PCK_NM" ).append("\n");
		query.append(",        IMDG_UN_NO" ).append("\n");
		query.append(",        IMDG_CLSS_CD" ).append("\n");
		query.append(",        PRP_SHP_NM" ).append("\n");
		query.append(",        HZD_DESC" ).append("\n");
		query.append(",        FLSH_PNT_CDO_TEMP" ).append("\n");
		query.append(",        EMER_CNTC_PHN_NO_CTNT" ).append("\n");
		query.append("FROM     BKG_DG_CGO A" ).append("\n");
		query.append("WHERE    BKG_NO = @[bkg_no]" ).append("\n");
		query.append("ORDER BY DCGO_SEQ" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n");
		query.append("FileName : BLDocumentationBLDBDAODGCargoRSQL").append("\n");
		query.append("*/").append("\n");
	}
}