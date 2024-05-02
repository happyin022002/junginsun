/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedNewSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.25
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.02.25 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedNewSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Unplaned S/O일 경우 cost_act_grp_seq가 600일 경우엔 새로운 번호로 채번한다.
	  * 새로운 cost_act_grp_seq를 채번하는 sql
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedNewSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration ").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedNewSeqRSQL").append("\n"); 
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
		query.append("SELECT CEIL((600 + COST_ACT_GRP_SEQ) / 2) NEW_COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ACT_GRP_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =" ).append("\n"); 
		query.append("(SELECT PCTL_NO" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no])" ).append("\n"); 
		query.append("AND COST_ACT_GRP_SEQ > 600" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 

	}
}