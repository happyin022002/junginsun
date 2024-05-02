/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPsaBkgCntrNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.09
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPsaBkgCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * PSA BKG CNTR NO를 조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPsaBkgCntrNoRSQL(){
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
		params.put("psa_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration ").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchPsaBkgCntrNoRSQL").append("\n");
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
		query.append("SELECT N1ST_CNTR_NO" ).append("\n");
		query.append(", N2ND_CNTR_NO" ).append("\n");
		query.append(", N3RD_CNTR_NO" ).append("\n");
		query.append(", N4TH_CNTR_NO" ).append("\n");
		query.append(", N5TH_CNTR_NO" ).append("\n");
		query.append(", N6TH_CNTR_NO" ).append("\n");
		query.append("FROM   BKG_CSTMS_PSA_CNTR" ).append("\n");
		query.append("WHERE  BKG_NO     =   @[bkg_no]" ).append("\n");
		query.append("AND    BKG_SEQ    =   @[bkg_seq]" ).append("\n");
		query.append("AND    PSA_SER_NO =   @[psa_ser_no]" ).append("\n");

	}
}