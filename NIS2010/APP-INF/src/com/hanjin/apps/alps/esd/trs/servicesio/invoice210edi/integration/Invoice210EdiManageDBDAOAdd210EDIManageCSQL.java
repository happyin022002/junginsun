/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Invoice210EdiManageDBDAOAdd210EDIManageCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.12.01 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Invoice210EdiManageDBDAOAdd210EDIManageCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * add210EDIManage INSERT
	  * </pre>
	  */
	public Invoice210EdiManageDBDAOAdd210EDIManageCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_edi_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.integration").append("\n"); 
		query.append("FileName : Invoice210EdiManageDBDAOAdd210EDIManageCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_INV_EDI" ).append("\n"); 
		query.append("(TRSP_INV_EDI_SEQ        ," ).append("\n"); 
		query.append("INV_NO                  ," ).append("\n"); 
		query.append("TRSP_WO_OFC_CTY_CD      ," ).append("\n"); 
		query.append("TRSP_WO_SEQ             ," ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD      ," ).append("\n"); 
		query.append("TRSP_SO_SEQ             ," ).append("\n"); 
		query.append("EQ_NO                   ," ).append("\n"); 
		query.append("EQ_TPSZ_CD              ," ).append("\n"); 
		query.append("BKG_NO                  ," ).append("\n"); 
		query.append("INV_AMT                 ," ).append("\n"); 
		query.append("INV_CURR_CD             ," ).append("\n"); 
		query.append("INV_ISS_DT              ," ).append("\n"); 
		query.append("CRE_USR_ID              ," ).append("\n"); 
		query.append("CRE_DT                  ," ).append("\n"); 
		query.append("UPD_USR_ID              ," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[trsp_inv_edi_seq]		," ).append("\n"); 
		query.append("@[inv_no]                ," ).append("\n"); 
		query.append("@[trsp_wo_ofc_cty_cd]    ," ).append("\n"); 
		query.append("TO_NUMBER(@[trsp_wo_seq])," ).append("\n"); 
		query.append("@[trsp_so_ofc_cty_cd]    ," ).append("\n"); 
		query.append("TO_NUMBER(@[trsp_so_seq])," ).append("\n"); 
		query.append("@[eq_no]                 ," ).append("\n"); 
		query.append("@[eq_tpsz_cd]            ," ).append("\n"); 
		query.append("@[bkg_no]                ," ).append("\n"); 
		query.append("TO_NUMBER(@[inv_amt])    ," ).append("\n"); 
		query.append("@[inv_curr_cd]           ," ).append("\n"); 
		query.append("SYSDATE                  ," ).append("\n"); 
		query.append("'SYSTEM'            ," ).append("\n"); 
		query.append("SYSDATE                  ," ).append("\n"); 
		query.append("'SYSTEM'             ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}