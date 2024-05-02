/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchEqTypeSizeListOfAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchEqTypeSizeListOfAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 장비 Lease시 발생한 AGMT No.에 등록된 장비의 Type & Size를 체크하여 조회한다.
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchEqTypeSizeListOfAgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchEqTypeSizeListOfAgmtRSQL").append("\n"); 
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
		query.append("SELECT AA.CNTR_TPSZ_CD AS CODE, AA.CNTR_TPSZ_DESC AS CODE_NM" ).append("\n"); 
		query.append("  FROM MDM_CNTR_TP_SZ AA, " ).append("\n"); 
		query.append("      (SELECT DISTINCT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        FROM LSE_AGMT_RT" ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
		query.append("         AND AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("         AND AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("         AND CNTR_RNTL_CHG_TP_CD = 'GENV'" ).append("\n"); 
		query.append("       ) BB " ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("    AND AA.CNTR_TPSZ_CD = BB.CNTR_TPSZ_CD" ).append("\n"); 

	}
}