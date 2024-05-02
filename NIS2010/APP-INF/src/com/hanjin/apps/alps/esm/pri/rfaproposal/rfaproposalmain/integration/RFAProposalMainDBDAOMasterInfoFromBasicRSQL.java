/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RFAProposalMainDBDAOMasterInfoFromBasicRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOMasterInfoFromBasicRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAProposalMainDBDAOMasterInfoFromBasicRSQL
	  *  
	  * * 2016.07.20 [CHM-201642287] Basic RFA의 amdt가 0일때는 Copy한 Master의 Exp date를, amdt가 0이 아닐 때는 auto amend 대상 amdt의 Exp date를 취득한다.
	  * </pre>
	  */
	public RFAProposalMainDBDAOMasterInfoFromBasicRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOMasterInfoFromBasicRSQL").append("\n"); 
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
		query.append("select A.PROP_NO, MST_HDR.PROP_NO AS MST_PROP_NO  ,B.MST_RFA_NO,B.MST_AMDT_SEQ " ).append("\n"); 
		query.append("from PRI_RP_MN A, PRI_RP_HDR B, PRI_RP_HDR MST_HDR" ).append("\n"); 
		query.append("WHERE A.PROP_NO =  @[prop_no]" ).append("\n"); 
		query.append("    AND A.PROP_NO = B.PROP_NO AND A.AMDT_SEQ =@[amdt_seq]" ).append("\n"); 
		query.append("    AND B.MST_RFA_NO = MST_HDR.RFA_NO" ).append("\n"); 

	}
}