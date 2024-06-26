/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOUpdate404EdiScePlnSoList3USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.08.18 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOUpdate404EdiScePlnSoList3USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE의 테이블에 Frustrate 상태 수정 SQL
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOUpdate404EdiScePlnSoList3USQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration ").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOUpdate404EdiScePlnSoList3USQL").append("\n"); 
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
		query.append("UPDATE SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("TRSP_SO_STS_CD = 'F'" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND 	COST_ACT_GRP_SEQ = @[cost_act_grp_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}