/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CODCorrectionDBDAOSearchCodRsoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.02
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.11.02 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOSearchCodRsoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * route 변경건에 대한 RSO와 OPF 요청 대상인지 조회한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOSearchCodRsoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rhnd_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOSearchCodRsoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(M.CONTI_CD,'F','EUR','E','EUR','A','ASR','M','AMR') RSO" ).append("\n"); 
		query.append("  FROM MDM_LOCATION M" ).append("\n"); 
		query.append(" WHERE M.LOC_CD      = SUBSTR(@[cod_rhnd_port_cd], 1, 5)" ).append("\n"); 
		query.append("   AND M.DELT_FLG    = 'N'" ).append("\n"); 

	}
}