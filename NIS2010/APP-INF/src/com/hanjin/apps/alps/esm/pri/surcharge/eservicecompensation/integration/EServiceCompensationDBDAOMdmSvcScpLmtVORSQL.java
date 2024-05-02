/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EServiceCompensationDBDAOMdmSvcScpLmtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.12.17 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EServiceCompensationDBDAOMdmSvcScpLmtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * E-SVC Compensation origin, dest sheet 콤보 조회
	  * </pre>
	  */
	public EServiceCompensationDBDAOMdmSvcScpLmtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration").append("\n"); 
		query.append("FileName : EServiceCompensationDBDAOMdmSvcScpLmtVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS SVC_SCP_CD" ).append("\n"); 
		query.append(",'' AS ORG_DEST_CD" ).append("\n"); 
		query.append(",'' AS DELT_FLG" ).append("\n"); 
		query.append(",A.RGN_CD" ).append("\n"); 
		query.append(",B.RGN_NM" ).append("\n"); 
		query.append(",A.ORG_DEST_CD" ).append("\n"); 
		query.append(",A.RGN_CD AS CD" ).append("\n"); 
		query.append(",B.RGN_NM AS NM" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP_LMT A" ).append("\n"); 
		query.append(",MDM_REGION B" ).append("\n"); 
		query.append("WHERE A.RGN_CD = B.RGN_CD" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '' && ${svc_scp_cd} != 'null' && ${svc_scp_cd} != 'NULL')" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_dest_cd} != '' && ${org_dest_cd} != 'null' && ${org_dest_cd} != 'NULL')" ).append("\n"); 
		query.append("AND A.ORG_DEST_CD = @[org_dest_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '' && ${delt_flg} != 'null' && ${delt_flg} != 'NULL')" ).append("\n"); 
		query.append("AND A.DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}