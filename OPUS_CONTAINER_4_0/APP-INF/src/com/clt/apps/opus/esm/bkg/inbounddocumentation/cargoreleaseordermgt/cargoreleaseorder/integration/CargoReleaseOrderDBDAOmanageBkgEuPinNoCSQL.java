/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOmanageBkgEuPinNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOmanageBkgEuPinNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_EU_PIN_NO 테이블 처리
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOmanageBkgEuPinNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_ord_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pin_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOmanageBkgEuPinNoCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_EU_PIN_NO A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT @[bkg_no] BKG_NO, @[cntr_no] CNTR_NO, @[rlse_ord_seq] RLSE_ORD_SEQ, @[pin_no] PIN_NO" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (A.BKG_NO = B.BKG_NO AND A.CNTR_NO = B.CNTR_NO AND A.RLSE_ORD_SEQ = B.RLSE_ORD_SEQ AND A.PIN_NO = B.PIN_NO)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET  UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append("               ,UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (BKG_NO, CNTR_NO, RLSE_ORD_SEQ, RLSE_ORD_SUB_SEQ, PIN_NO, SND_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("    VALUES (@[bkg_no], @[cntr_no], @[rlse_ord_seq], @[rlse_ord_sub_seq], @[pin_no], @[snd_flg], @[cre_usr_id], SYSDATE, @[upd_usr_id], SYSDATE)" ).append("\n"); 

	}
}