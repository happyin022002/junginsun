/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRefNo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchRefNoRSQL").append("\n"); 
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
		query.append("SELECT '{REF_INFO' ||CHR(10) || " ).append("\n"); 
		query.append("       'REF_TP_CD:'|| '03'||CHR(10) || " ).append("\n"); 
		query.append("       'REF_NO:' || NVL(SC_NO, NVL(RFA_NO, TAA_NO)) ||CHR(10) || " ).append("\n"); 
		query.append("       '}REF_INFO'  ||CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND (SC_NO IS NOT NULL OR RFA_NO IS NOT NULL OR TAA_NO IS NOT NULL)" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       '{REF_INFO' ||CHR(10) || " ).append("\n"); 
		query.append("       'REF_TP_CD:'|| '10'||CHR(10) || " ).append("\n"); 
		query.append("       'REF_NO:' || MST_BKG_NO ||CHR(10) || " ).append("\n"); 
		query.append("       '}REF_INFO'  ||CHR(10)" ).append("\n"); 
		query.append("FROM BKG_CNTR_RT" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND MST_BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT '{REF_INFO' ||CHR(10) || " ).append("\n"); 
		query.append("       'REF_TP_CD:'|| DECODE(BKG_REF_TP_CD,'BKPO', '17','EBSH', '13', 'EBFF', '23', 'FINV', '25', '')||CHR(10) || " ).append("\n"); 
		query.append("       'REF_NO:' || CUST_REF_NO_CTNT ||CHR(10) || " ).append("\n"); 
		query.append("       '}REF_INFO'  ||CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A" ).append("\n"); 
		query.append("      ,BKG_REFERENCE B " ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND B.BKG_REF_TP_CD IN ('BKPO','EBSH','EBFF','FINV')" ).append("\n"); 
		query.append("AND B.CUST_REF_NO_CTNT IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT '{REF_INFO' ||CHR(10) || " ).append("\n"); 
		query.append("       'REF_TP_CD:'|| '21'||CHR(10) || " ).append("\n"); 
		query.append("       'REF_NO:' || DE_NO ||CHR(10) || " ).append("\n"); 
		query.append("       '}REF_INFO'  ||CHR(10)" ).append("\n"); 
		query.append("FROM BKG_REF_DTL " ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND DE_NO IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT '{REF_INFO' ||CHR(10) || " ).append("\n"); 
		query.append("       'REF_TP_CD:'|| '26'||CHR(10) || " ).append("\n"); 
		query.append("       'REF_NO:' || INV_NO ||CHR(10) || " ).append("\n"); 
		query.append("       '}REF_INFO'  ||CHR(10)" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND INV_NO IS NOT NULL" ).append("\n"); 

	}
}