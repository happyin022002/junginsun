/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PSAManifestDBDAOsearchBkgQtyInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.05
*@LastModifier :
*@LastVersion : 1.0
* 2013.08.05
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchBkgQtyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BKG Quantity정보를 조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchBkgQtyInfoRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchBkgQtyInfoRSQL").append("\n");
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
		query.append("SELECT QTY.CNTR_TPSZ_CD CNTRTS_CD" ).append("\n");
		query.append("     , DECODE(QTY.BB_CGO_QTY,'1','0',DECODE( SUBSTR( QTY.CNTR_TPSZ_CD, 2, 1 ), '2', '2', '4', '4', '5', '4', '7', '5','8','8','9','8','0' )) CNTR_SZ" ).append("\n");
		query.append("     , CEIL( QTY.OP_CNTR_QTY) QTY" ).append("\n");
		query.append("     , CEIL( QTY.DCGO_QTY   ) DG_QTY" ).append("\n");
		query.append("     , CEIL( QTY.AWK_CGO_QTY) AK_QTY" ).append("\n");
		query.append("     , CEIL( GREATEST( QTY.RC_QTY, QTY.OP_CNTR_QTY - (CASE WHEN SUBSTR(CNTR_TPSZ_CD, 1,1) = 'R' AND SUBSTR(EQ_SUBST_CNTR_TPSZ_CD,1,1)= 'D' THEN NVL(EQ_SUBST_CGO_QTY, 0) ELSE 0 END ) )) RF_QTY" ).append("\n");
		query.append("     , DECODE(QTY.CNTR_TPSZ_CD,'D5','HC','D7','HC','R5','HC','R7','HC','D9','HC', '') CNTR_HEIGHT" ).append("\n");
		query.append("     , (SELECT MAX(CNTR_NO) FROM BKG_CONTAINER CNTR WHERE BB_CGO_FLG = 'Y' AND CNTR.BKG_NO = QTY.BKG_NO) CNTR_NO" ).append("\n");
		query.append("FROM        BKG_QUANTITY QTY, BKG_BB_CGO CGO" ).append("\n");
		query.append("WHERE       QTY.BKG_NO       =  @[bkg_no]" ).append("\n");
		query.append("AND         QTY.BKG_NO = CGO.BKG_NO(+)" ).append("\n");
		query.append("AND         QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n");
		query.append("AND         QTY.OP_CNTR_QTY  >   0" ).append("\n");

	}
}