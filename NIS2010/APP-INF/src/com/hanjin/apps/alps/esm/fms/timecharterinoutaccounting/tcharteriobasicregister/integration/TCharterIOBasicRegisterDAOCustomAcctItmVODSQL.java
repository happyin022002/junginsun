/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.23 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon Seyeong
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class TCharterIOBasicRegisterDAOCustomAcctItmVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOBasicRegisterDAOCustomAcctItmVODSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("#if (${condflag} == \"item\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("delete from fms_acct_itm" ).append("\n"); 
		query.append("where	acct_cd = @[acct_cd]" ).append("\n"); 
		query.append("and	acct_itm_seq = @[acct_itm_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${condflag} == \"category\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("delete from fms_acct_cate" ).append("\n"); 
		query.append("where	acct_cd = @[acct_cd]" ).append("\n"); 
		query.append("and	acct_itm_seq = @[acct_itm_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}