/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchAwkCgoInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.08
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

public class PSAManifestDBDAOsearchAwkCgoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Awkward Cargo Infomation을 조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchAwkCgoInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration ").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchAwkCgoInfoRSQL").append("\n");
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
		query.append("SELECT      DECODE( NVL( OVR_HGT      , 0 )                             , 0, 'N', 'Y' ) AK_OH," ).append("\n");
		query.append("DECODE( NVL( OVR_LF_LEN   , 0 ) + NVL( OVR_RT_LEN     , 0 ) , 0, 'N', 'Y' ) AK_OW," ).append("\n");
		query.append("DECODE( NVL( OVR_FWRD_LEN , 0 ) + NVL( OVR_BKWD_LEN   , 0 ) , 0, 'N', 'Y' ) AK_OL," ).append("\n");
		query.append("COUNT(*) AK_QTY" ).append("\n");
		query.append("FROM        BKG_AWK_CGO" ).append("\n");
		query.append("WHERE       BKG_NO         =   @[bkg_no]" ).append("\n");
		query.append("AND     CNTR_TPSZ_CD       =   @[cntr_tpsz_cd]" ).append("\n");
		query.append("AND     NVL( OVR_HGT, 0 ) + NVL( OVR_LF_LEN, 0 ) + NVL( OVR_RT_LEN, 0 ) +" ).append("\n");
		query.append("NVL( OVR_FWRD_LEN, 0 ) + NVL( OVR_BKWD_LEN, 0 ) > 0" ).append("\n");
		query.append("GROUP BY    DECODE( NVL( OVR_HGT        , 0 )                           , 0, 'N', 'Y' ) ," ).append("\n");
		query.append("DECODE( NVL( OVR_LF_LEN     , 0 ) + NVL( OVR_RT_LEN   , 0 ) , 0, 'N', 'Y' )   ," ).append("\n");
		query.append("DECODE( NVL( OVR_FWRD_LEN   , 0 ) + NVL( OVR_BKWD_LEN , 0 ) , 0, 'N', 'Y' )" ).append("\n");

	}
}