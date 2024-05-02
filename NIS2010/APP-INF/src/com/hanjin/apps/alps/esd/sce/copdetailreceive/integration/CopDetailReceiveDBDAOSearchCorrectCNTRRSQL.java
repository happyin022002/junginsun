/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchCorrectCNTRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.19 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchCorrectCNTRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCorrectCNTR
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchCorrectCNTRRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pActRcvTpCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inCntrTpszCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inBkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inOrgYdCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchCorrectCNTRRSQL").append("\n"); 
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
		query.append("SELECT c.cop_no    v_chg_cop_no" ).append("\n"); 
		query.append("      ,c.cntr_no   i_correct_cntr_no" ).append("\n"); 
		query.append("      ,c.cnmv_yr   i_correct_cnmv_yr" ).append("\n"); 
		query.append("FROM sce_cop_dtl  a" ).append("\n"); 
		query.append("    ,sce_act_act_mapg b" ).append("\n"); 
		query.append("    ,sce_cop_hdr c" ).append("\n"); 
		query.append("WHERE  a.cop_no          = c.cop_no" ).append("\n"); 
		query.append("AND    c.bkg_no          = @[inBkgNo]" ).append("\n"); 
		query.append("AND    a.nod_cd          = @[inOrgYdCd]" ).append("\n"); 
		query.append("AND    a.act_cd          = b.act_cd" ).append("\n"); 
		query.append("AND    b.act_rcv_tp_cd   = @[pActRcvTpCd]" ).append("\n"); 
		query.append("AND    c.cop_sts_cd      not in ( 'X', 'O' )" ).append("\n"); 
		query.append("AND    b.act_sts_mapg_cd = 'OC'" ).append("\n"); 
		query.append("AND    c.cntr_tpsz_cd    = @[inCntrTpszCd] " ).append("\n"); 
		query.append("AND    c.CNTR_NO         <> 'SMCU0000000'" ).append("\n"); 

	}
}