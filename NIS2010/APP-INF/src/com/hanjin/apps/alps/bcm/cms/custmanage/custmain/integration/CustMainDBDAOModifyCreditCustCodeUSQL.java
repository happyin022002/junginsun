/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOModifyCreditCustCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOModifyCreditCustCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Credit Customer auto invoice update
	  * </pre>
	  */
	public CustMainDBDAOModifyCreditCustCodeUSQL(){
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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration ").append("\n"); 
		query.append("FileName : CustMainDBDAOModifyCreditCustCodeUSQL").append("\n"); 
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
		query.append("UPDATE MDM_CR_CUST MCC" ).append("\n"); 
		query.append("SET (MCC.AUTO_INV_IB_FLG" ).append("\n"); 
		query.append("      ,MCC.AUTO_INV_IB_HJS_REF_NO" ).append("\n"); 
		query.append("      ,MCC.AUTO_INV_IB_CUST_REF_NO_FLG" ).append("\n"); 
		query.append("      ,MCC.AUTO_INV_IB_LOCL_CHG_FLG" ).append("\n"); 
		query.append("      ,MCC.AUTO_INV_IB_EML)" ).append("\n"); 
		query.append("    = (SELECT MCR.AUTO_INV_FLG" ).append("\n"); 
		query.append("              , MCR.HJS_REF_NO" ).append("\n"); 
		query.append("              , MCR.CUST_REF_NO_FLG" ).append("\n"); 
		query.append("              , MCR.LOCL_CHG_FLG" ).append("\n"); 
		query.append("              , MCR.HJS_REF_EML" ).append("\n"); 
		query.append("       FROM MDM_CUST_REP MCR " ).append("\n"); 
		query.append("       WHERE MCR.CUST_CNT_CD = MCC.CUST_CNT_CD " ).append("\n"); 
		query.append("       AND MCR.CUST_SEQ = MCC.CUST_SEQ " ).append("\n"); 
		query.append("       AND MCR.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("       AND ROWNUM = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("     ,(MCC.AUTO_INV_OB_FLG" ).append("\n"); 
		query.append("      ,MCC.AUTO_INV_OB_HJS_REF_NO" ).append("\n"); 
		query.append("      ,MCC.AUTO_INV_OB_CUST_REF_NO_FLG" ).append("\n"); 
		query.append("      ,MCC.AUTO_INV_OB_LOCL_CHG_FLG" ).append("\n"); 
		query.append("      ,MCC.AUTO_INV_OB_EML)" ).append("\n"); 
		query.append("    = (SELECT MCR.AUTO_INV_FLG" ).append("\n"); 
		query.append("              , MCR.HJS_REF_NO" ).append("\n"); 
		query.append("              , MCR.CUST_REF_NO_FLG" ).append("\n"); 
		query.append("              , MCR.LOCL_CHG_FLG" ).append("\n"); 
		query.append("              , MCR.HJS_REF_EML" ).append("\n"); 
		query.append("       FROM MDM_CUST_REP MCR " ).append("\n"); 
		query.append("       WHERE MCR.CUST_CNT_CD = MCC.CUST_CNT_CD " ).append("\n"); 
		query.append("       AND MCR.CUST_SEQ = MCC.CUST_SEQ " ).append("\n"); 
		query.append("       AND MCR.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("       AND ROWNUM = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE MCC.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND MCC.CUST_SEQ = @[cust_seq]" ).append("\n"); 

	}
}