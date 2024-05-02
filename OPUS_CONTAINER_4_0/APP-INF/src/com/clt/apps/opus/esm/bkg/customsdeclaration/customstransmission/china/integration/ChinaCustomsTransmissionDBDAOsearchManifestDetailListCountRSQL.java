/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchManifestDetailListCountRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.18
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchManifestDetailListCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchManifestDetailListCount
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchManifestDetailListCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n");
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchManifestDetailListCountRSQL").append("\n");
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
		query.append("SELECT  COUNT(*) AS TOTAL" ).append("\n");
		query.append("FROM   BKG_CSTMS_CHN_BL BL" ).append("\n");
		query.append("WHERE  BL.VSL_CD	            = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND    BL.SKD_VOY_NO	        = SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND    BL.SKD_DIR_CD	        = SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("AND    DECODE(@[trans_mode],'O',BL.BKG_POL_CD,'D',BL.BKG_POD_CD,BL.BKG_POL_CD) = @[loc_cd]" ).append("\n");
		query.append("AND    DECODE(BL.BKG_CGO_TP_CD,'P','P','F') LIKE @[bkg_cgo_tp_cd]||'%'" ).append("\n");
		query.append("AND    BL.CHN_MF_SND_IND_CD LIKE @[trans_mode]||'%'" ).append("\n");

	}
}