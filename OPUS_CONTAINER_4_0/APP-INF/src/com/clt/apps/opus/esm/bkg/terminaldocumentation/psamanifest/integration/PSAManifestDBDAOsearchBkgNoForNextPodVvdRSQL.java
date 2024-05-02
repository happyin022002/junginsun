/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchBkgNoForNextPodVvdRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier :
*@LastVersion : 1.0
* 2010.03.23
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

public class PSAManifestDBDAOsearchBkgNoForNextPodVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Import의 경우 NextPod, Next VVD조회를 위해 BKG No를 구한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchBkgNoForNextPodVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntrNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration ").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchBkgNoForNextPodVvdRSQL").append("\n");
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
		query.append("SELECT DISTINCT vvd2.BKG_NO BKG_NO" ).append("\n");
		query.append("FROM   BKG_VVD vvd2, BKG_CONTAINER cntr" ).append("\n");
		query.append("WHERE    vvd2.VSL_CD = substr(@[vvdCd],1,4)" ).append("\n");
		query.append("AND      vvd2.SKD_VOY_NO = substr(@[vvdCd],5,4)" ).append("\n");
		query.append("AND      vvd2.SKD_DIR_CD = substr(@[vvdCd],9,1)" ).append("\n");
		query.append("AND      vvd2.POD_CD = 'SGSIN'" ).append("\n");
		query.append("AND      vvd2.BKG_NO = cntr.BKG_NO" ).append("\n");
		query.append("and      cntr.cntr_no = @[cntrNo]" ).append("\n");
		query.append("AND      exists (SELECT 'x' FROM BKG_BOOKING bkg, BKG_VVD vvd1" ).append("\n");
		query.append("WHERE vvd2.BKG_NO = bkg.BKG_NO" ).append("\n");
		query.append("AND   bkg.BKG_STS_CD <> 'X'" ).append("\n");
		query.append("AND   vvd1.BKG_NO = bkg.BKG_NO" ).append("\n");
		query.append("AND   vvd1.POL_CD = 'SGSIN')" ).append("\n");
		query.append("AND    ROWNUM = 1" ).append("\n");

	}
}