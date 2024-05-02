/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.10.13 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailDSQL").append("\n"); 
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
		query.append("DELETE FROM CIM_CNTR_STK" ).append("\n"); 
		query.append("WHERE STK_LOC_CD = SUBSTR (@[empty_cy], 1, 5)" ).append("\n"); 
		query.append("AND STK_YD_CD = @[empty_cy]" ).append("\n"); 
		query.append("#if (${type} == 'RLS')" ).append("\n"); 
		query.append("AND STK_GATE_IO_CD = 'O'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND STK_GATE_IO_CD = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SO_OFC_CTY_CD = @[so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND SO_SEQ = @[so_seq]" ).append("\n"); 
		query.append("AND TRSP_SO_TP_CD = @[type_cd]" ).append("\n"); 

	}
}