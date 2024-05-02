/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EServiceCompensationDBDAOPriCmpnEsvcNewCmpnSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.04.29 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EServiceCompensationDBDAOPriCmpnEsvcNewCmpnSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * E-SVC Compensation 의 New cmpn_seq 조회
	  * </pre>
	  */
	public EServiceCompensationDBDAOPriCmpnEsvcNewCmpnSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration").append("\n"); 
		query.append("FileName : EServiceCompensationDBDAOPriCmpnEsvcNewCmpnSeqRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(PRI_CMPN_ESVC XPKPRI_CMPN_ESVC) */" ).append("\n"); 
		query.append("       CMPN_SEQ +1 AS CMPN_SEQ" ).append("\n"); 
		query.append("FROM PRI_CMPN_ESVC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}