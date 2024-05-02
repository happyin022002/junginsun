/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOModifyOfficeSingleTransportationVoPrdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.08.03 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOModifyOfficeSingleTransportationVoPrdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O Trans Office PRD Update
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOModifyOfficeSingleTransportationVoPrdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration ").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOModifyOfficeSingleTransportationVoPrdUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_ACT_GRP_DTL" ).append("\n"); 
		query.append("SET CTRL_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("WHERE PCTL_NO         = (" ).append("\n"); 
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE COP_NO   = @[cop_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND COST_ACT_GRP_SEQ = @[cost_act_grp_seq]" ).append("\n"); 

	}
}