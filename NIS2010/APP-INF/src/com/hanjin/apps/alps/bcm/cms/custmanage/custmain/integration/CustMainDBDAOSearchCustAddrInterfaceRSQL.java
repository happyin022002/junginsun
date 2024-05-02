/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOSearchCustAddrInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOSearchCustAddrInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer address interface
	  * </pre>
	  */
	public CustMainDBDAOSearchCustAddrInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("addr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOSearchCustAddrInterfaceRSQL").append("\n"); 
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
		query.append("SELECT MC.CRM_ROW_ID Cust_Mst_Row_Id " ).append("\n"); 
		query.append("      ,MCA.CRM_ROW_ID Cust_Addr_Row_Id" ).append("\n"); 
		query.append("      ,DECODE(MCA.DELT_FLG,'Y','D','A') Cust_Addr_Sts_Cd" ).append("\n"); 
		query.append("      ,MCA.Cust_Cnt_Cd    " ).append("\n"); 
		query.append("      ,MCA.Cust_Seq      " ).append("\n"); 
		query.append("      ,Addr_Tp_Cd     " ).append("\n"); 
		query.append("      ,Addr_Seq      " ).append("\n"); 
		query.append("      ,Prmry_Chk_Flg  " ).append("\n"); 
		query.append("      ,'' Bzet_Cnt_Cd    " ).append("\n"); 
		query.append("      ,'' Bzet_Seq" ).append("\n"); 
		query.append("      ,Bzet_Nm       " ).append("\n"); 
		query.append("      ,Bzet_Addr     " ).append("\n"); 
		query.append("      ,Cty_Nm        " ).append("\n"); 
		query.append("      ,Ste_Cd        " ).append("\n"); 
		query.append("      ,Zip_Cd        " ).append("\n"); 
		query.append("      ,Cnt_Cd        " ).append("\n"); 
		query.append("      ,Cntc_Eml      " ).append("\n"); 
		query.append("      ,Cntc_Pson_Nm   " ).append("\n"); 
		query.append("      ,Bzet_Rmk      " ).append("\n"); 
		query.append("      ,'' Intl_Phn_No    " ).append("\n"); 
		query.append("      ,'' Arct_Phn_No    " ).append("\n"); 
		query.append("      ,'' Phn_No        " ).append("\n"); 
		query.append("      ,'' Full_Phn_No    " ).append("\n"); 
		query.append("      ,'' Intl_Fax_No    " ).append("\n"); 
		query.append("      ,'' Arct_Fax_No    " ).append("\n"); 
		query.append("      ,'' Fax_No        " ).append("\n"); 
		query.append("      ,'' Full_Fax_No    " ).append("\n"); 
		query.append("      ,MCA.Cre_Usr_Id     " ).append("\n"); 
		query.append("      ,TO_CHAR(MCA.Cre_Dt,'YYYYMMDDHH24MISS') Cre_Dt       " ).append("\n"); 
		query.append("      ,MCA.Upd_Usr_Id     " ).append("\n"); 
		query.append("      ,TO_CHAR(MCA.Upd_Dt,'YYYYMMDDHH24MISS') Upd_Dt      " ).append("\n"); 
		query.append("      ,MCA.Delt_Flg      " ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("     ,MDM_CUST_ADDR MCA" ).append("\n"); 
		query.append("WHERE MC.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND MC.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND MCA.ADDR_SEQ = @[addr_seq]" ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD = MCA.CUST_CNT_CD" ).append("\n"); 
		query.append("AND MC.CUST_SEQ = MCA.CUST_SEQ" ).append("\n"); 

	}
}