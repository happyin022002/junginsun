/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOremovePsaBkgForYardCdDSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier :
*@LastVersion : 1.0
* 2010.03.29
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOremovePsaBkgForYardCdDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Yard Assign By CNTR화면에서 Row Delete
	  * </pre>
	  */
	public PSAManifestDBDAOremovePsaBkgForYardCdDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_if_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOremovePsaBkgForYardCdDSQL").append("\n");
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
		query.append("DELETE BKG_CSTMS_PSA_BKG" ).append("\n");
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND    BKG_SEQ = @[bkg_seq]" ).append("\n");
		query.append("AND    PSA_IF_CD = @[psa_if_cd]" ).append("\n");
		query.append("AND    (SELECT COUNT(*) FROM BKG_CSTMS_PSA_CNTR WHERE BKG_NO = @[bkg_no] AND BKG_SEQ = @[bkg_seq]) < 1" ).append("\n");
		query.append("AND    (SELECT COUNT(*) FROM BKG_CSTMS_PSA_RLSE_ORD WHERE BKG_NO = @[bkg_no] AND BKG_SEQ = @[bkg_seq]) < 1" ).append("\n");

	}
}