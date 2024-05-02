/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RehandExpmanageDBDAOPortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RehandExpmanageDBDAOPortListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PortList를 조회한다.
	  * </pre>
	  */
	public RehandExpmanageDBDAOPortListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_port_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vop_port_mntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.terminalmanage.integration").append("\n"); 
		query.append("FileName : RehandExpmanageDBDAOPortListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("T1.LOC_CD" ).append("\n"); 
		query.append(",T1.LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION T1, MDM_COUNTRY T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.CNT_CD=T2.CNT_CD" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("AND T1.CNT_CD LIKE upper(@[cnt_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("AND T1.LOC_CD LIKE upper(@[loc_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_nm} != '') " ).append("\n"); 
		query.append("AND T1.LOC_NM LIKE '%' || upper(@[loc_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vskd_port_rhq_cd} != '' && ${vskd_port_rhq_cd} != 'ALL') " ).append("\n"); 
		query.append("AND T1.VSKD_PORT_RHQ_CD = @[vskd_port_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vop_port_mntr_flg} != '')" ).append("\n"); 
		query.append("AND T1.VOP_PORT_MNTR_FLG=@[vop_port_mntr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND T1.CALL_PORT_FLG='Y'" ).append("\n"); 
		query.append("AND T1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY LOC_CD" ).append("\n"); 

	}
}