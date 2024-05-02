/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOSearchUNLocCdRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.18
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.07.18 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOSearchUNLocCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Kor24CustomsTransmissionDBDAOSearchUNLocCdRSQL
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOSearchUNLocCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration").append("\n");
		query.append("FileName : Kor24CustomsTransmissionDBDAOSearchUNLocCdRSQL").append("\n");
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
		query.append("SELECT NVL(L1.UN_LOC_CD, L1.LOC_CD) POL_UN   " ).append("\n");
		query.append(", NVL(L2.UN_LOC_CD, L2.LOC_CD) POD_UN   " ).append("\n");
		query.append("FROM MDM_LOCATION L1   " ).append("\n");
		query.append(", MDM_LOCATION L2   " ).append("\n");
		query.append("WHERE L1.LOC_CD = @[pol_cd]   " ).append("\n");
		query.append("" ).append("\n");
		query.append("#if (${pod_cd} == 'CNYTN' || ${pod_cd} == 'CNYIT')  " ).append("\n");
		query.append("" ).append("\n");
		query.append("AND NVL(L2.UN_LOC_CD, L2.LOC_CD) = 'CNYTN'" ).append("\n");
		query.append("" ).append("\n");
		query.append("#else " ).append("\n");
		query.append("" ).append("\n");
		query.append("AND L2.LOC_CD = @[pod_cd] " ).append("\n");
		query.append("" ).append("\n");
		query.append("#end" ).append("\n");

	}
}