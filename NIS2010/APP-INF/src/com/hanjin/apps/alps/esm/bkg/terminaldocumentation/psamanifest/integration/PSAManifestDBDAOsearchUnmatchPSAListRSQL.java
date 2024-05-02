/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestDBDAOsearchUnmatchPSAListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.16 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchUnmatchPSAListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUnmatchCNTRList에서 조회된 CNTR No를 인자값으로 하여 Unmatch PSA List를 조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchUnmatchPSAListRSQL(){
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
		params.put("rly_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration ").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchUnmatchPSAListRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(PSA_CNTR_TPSZ_CD,1,2) CNTR_TP_CD" ).append("\n"); 
		query.append(", SUBSTR(PSA_CNTR_TPSZ_CD,3,2) CNTR_SZ_CD" ).append("\n"); 
		query.append(", UND_DECK_TP_ID" ).append("\n"); 
		query.append("#if(${trans_tp_cd}!='E')" ).append("\n"); 
		query.append(", POL_CD PORT_CD /** IMPORT일때는 POL_CD **/" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", POD_CD PORT_CD /** IMPORT일때는 POL_CD **/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", REPLACE(SPCL_CGO_DTL_CTNT,'/','') SPECIAL" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_PSA_CNTR_CHK" ).append("\n"); 
		query.append("WHERE  VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND    RLY_PORT_CD = @[rly_port]" ).append("\n"); 
		query.append("AND    CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}