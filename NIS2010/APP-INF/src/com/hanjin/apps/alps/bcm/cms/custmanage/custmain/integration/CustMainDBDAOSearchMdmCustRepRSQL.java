/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOSearchMdmCustRepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.09 
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

public class CustMainDBDAOSearchMdmCustRepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM Customer Rep search
	  * </pre>
	  */
	public CustMainDBDAOSearchMdmCustRepRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOSearchMdmCustRepRSQL").append("\n"); 
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
		query.append("SELECT MCR.CUST_CNT_CD" ).append("\n"); 
		query.append("       ,MCR.CUST_SEQ" ).append("\n"); 
		query.append("       ,MCR.OFC_CD" ).append("\n"); 
		query.append("       ,MCR.IO_BND_CD" ).append("\n"); 
		query.append("       ,MCR.AUTO_INV_FLG" ).append("\n"); 
		query.append("       ,MCR.HJS_CUST_SVC_PIC_TP_CD" ).append("\n"); 
		query.append("       ,MCR.HJS_REF_NO" ).append("\n"); 
		query.append("       ,MCR.DELT_FLG" ).append("\n"); 
		query.append("       ,MCR.CUST_REF_NO_FLG" ).append("\n"); 
		query.append("       ,MCR.LOCL_CHG_FLG" ).append("\n"); 
		query.append("       ,MCR.AUTO_INV_EML" ).append("\n"); 
		query.append("       ,MCR.CRE_USR_ID" ).append("\n"); 
		query.append("       ,MCR.CRE_DT" ).append("\n"); 
		query.append("       ,MCR.UPD_USR_ID" ).append("\n"); 
		query.append("       ,MCR.UPD_DT" ).append("\n"); 
		query.append("  FROM MDM_CUST_REP	MCR" ).append("\n"); 
		query.append(" WHERE cust_cnt_cd  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND cust_seq 	= @[cust_seq]" ).append("\n"); 

	}
}