/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomerNominatedTruckerAproDAOSearchAgmtNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.12.17 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerNominatedTruckerAproDAOSearchAgmtNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement No조회
	  * </pre>
	  */
	public CustomerNominatedTruckerAproDAOSearchAgmtNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration").append("\n"); 
		query.append("FileName : CustomerNominatedTruckerAproDAOSearchAgmtNoRSQL").append("\n"); 
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
		query.append("SELECT   NVL2(SUBSTR(CNT_RT, 1, INSTR(CNT_RT, '$', 1, 1) -1), 'Y', 'N')  AGMT_FLG" ).append("\n"); 
		query.append("        ,SUBSTR(CNT_RT, 1, INSTR(CNT_RT, '$', 1, 1) -1) AGMT_NO" ).append("\n"); 
		query.append("FROM (SELECT TRS_GET_AGMT_TRKR_RATE_FNC(" ).append("\n"); 
		query.append("                @[vndr_seq]   --VNDR_SEQ" ).append("\n"); 
		query.append("               ,'D4' --CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               ,@[io_bnd_cd]   -- IO_BND_CD" ).append("\n"); 
		query.append("               ,'DR'" ).append("\n"); 
		query.append("               ,NULL --CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("               ,NULL --CTRT_CUST_SEQ" ).append("\n"); 
		query.append("               ,@[fm_nod] --FM_NODE" ).append("\n"); 
		query.append("               ,CASE WHEN LENGTH(@[dor_nod]) = 5  THEN @[dor_nod]||'01'" ).append("\n"); 
		query.append("                     ELSE @[dor_nod]" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("               ,@[to_nod] --TO_NODE" ).append("\n"); 
		query.append("             ) CNT_RT" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}