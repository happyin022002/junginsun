/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationBLDBDAOHblByXterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOHblByXterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eBKG에서 hbl 정보를 insert/update한다
	  * </pre>
	  */
	public BLDocumentationBLDBDAOHblByXterUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_si_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_mk_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_si_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hbl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_gds_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hbl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hbl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOHblByXterUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("MERGE INTO BKG_HBL_HIS A" ).append("\n"); 
		query.append("USING DUAL ON (a.bkg_no = @[bkg_no] AND CORR_NO='TMP0000001' AND a.hbl_seq = @[hbl_seq])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET HBL_NO = @[hbl_no]" ).append("\n"); 
		query.append(",	BL_MK_DESC = @[bl_mk_desc]" ).append("\n"); 
		query.append(",	BL_GDS_DESC = @[bl_gds_desc]" ).append("\n"); 
		query.append(",	HBL_WGT = @[hbl_wgt]" ).append("\n"); 
		query.append(",	WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",	PCK_QTY = @[pck_qty]" ).append("\n"); 
		query.append(",	PCK_TP_CD = @[pck_tp_cd]" ).append("\n"); 
		query.append(",	CMDT_MEAS_UT_CD = @[cmdt_meas_ut_cd]" ).append("\n"); 
		query.append(",	CMDT_MEAS_QTY = @[cmdt_meas_qty]" ).append("\n"); 
		query.append("#if (${xter_si_no} != '')" ).append("\n"); 
		query.append(",   XTER_SI_NO = @[xter_si_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${xter_si_seq} != '')" ).append("\n"); 
		query.append(",   XTER_SI_SEQ = @[xter_si_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (BKG_NO" ).append("\n"); 
		query.append(",      CORR_NO" ).append("\n"); 
		query.append(",      HBL_SEQ" ).append("\n"); 
		query.append(",      HBL_NO" ).append("\n"); 
		query.append(",      BL_MK_DESC" ).append("\n"); 
		query.append(",      BL_GDS_DESC" ).append("\n"); 
		query.append(",      HBL_WGT" ).append("\n"); 
		query.append(",      WGT_UT_CD" ).append("\n"); 
		query.append(",      PCK_QTY" ).append("\n"); 
		query.append(",      PCK_TP_CD" ).append("\n"); 
		query.append(",      CMDT_MEAS_UT_CD" ).append("\n"); 
		query.append(",      CMDT_MEAS_QTY" ).append("\n"); 
		query.append(",      XTER_SI_NO" ).append("\n"); 
		query.append(",      XTER_SI_SEQ" ).append("\n"); 
		query.append(",      CRE_USR_ID" ).append("\n"); 
		query.append(",      CRE_DT" ).append("\n"); 
		query.append(",      UPD_USR_ID" ).append("\n"); 
		query.append(",      UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (@[bkg_no]" ).append("\n"); 
		query.append(",   'TMP0000001'" ).append("\n"); 
		query.append(",	@[hbl_seq]" ).append("\n"); 
		query.append(",	@[hbl_no]" ).append("\n"); 
		query.append(",	@[bl_mk_desc]" ).append("\n"); 
		query.append(",	@[bl_gds_desc]" ).append("\n"); 
		query.append(",	@[hbl_wgt]" ).append("\n"); 
		query.append(",	@[wgt_ut_cd]" ).append("\n"); 
		query.append(",	@[pck_qty]" ).append("\n"); 
		query.append(",	@[pck_tp_cd]" ).append("\n"); 
		query.append(",	@[cmdt_meas_ut_cd]" ).append("\n"); 
		query.append(",	@[cmdt_meas_qty]" ).append("\n"); 
		query.append(",	@[xter_si_no]" ).append("\n"); 
		query.append(",	@[xter_si_seq]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MERGE INTO BKG_HBL A" ).append("\n"); 
		query.append("USING DUAL ON (a.bkg_no = @[bkg_no] AND a.hbl_seq = @[hbl_seq])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET HBL_NO = @[hbl_no]" ).append("\n"); 
		query.append(",	BL_MK_DESC = @[bl_mk_desc]" ).append("\n"); 
		query.append(",	BL_GDS_DESC = @[bl_gds_desc]" ).append("\n"); 
		query.append(",	HBL_WGT = @[hbl_wgt]" ).append("\n"); 
		query.append(",	WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",	PCK_QTY = @[pck_qty]" ).append("\n"); 
		query.append(",	PCK_TP_CD = @[pck_tp_cd]" ).append("\n"); 
		query.append(",	CMDT_MEAS_UT_CD = @[cmdt_meas_ut_cd]" ).append("\n"); 
		query.append(",	CMDT_MEAS_QTY = @[cmdt_meas_qty]" ).append("\n"); 
		query.append("#if (${xter_si_no} != '')" ).append("\n"); 
		query.append(",   XTER_SI_NO = @[xter_si_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${xter_si_seq} != '')" ).append("\n"); 
		query.append(",   XTER_SI_SEQ = @[xter_si_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (BKG_NO" ).append("\n"); 
		query.append(",      HBL_SEQ" ).append("\n"); 
		query.append(",      HBL_NO" ).append("\n"); 
		query.append(",      BL_MK_DESC" ).append("\n"); 
		query.append(",      BL_GDS_DESC" ).append("\n"); 
		query.append(",      HBL_WGT" ).append("\n"); 
		query.append(",      WGT_UT_CD" ).append("\n"); 
		query.append(",      PCK_QTY" ).append("\n"); 
		query.append(",      PCK_TP_CD" ).append("\n"); 
		query.append(",      CMDT_MEAS_UT_CD" ).append("\n"); 
		query.append(",      CMDT_MEAS_QTY" ).append("\n"); 
		query.append(",      XTER_SI_NO" ).append("\n"); 
		query.append(",      XTER_SI_SEQ" ).append("\n"); 
		query.append(",      CRE_USR_ID" ).append("\n"); 
		query.append(",      CRE_DT" ).append("\n"); 
		query.append(",      UPD_USR_ID" ).append("\n"); 
		query.append(",      UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (@[bkg_no]" ).append("\n"); 
		query.append(",	@[hbl_seq]" ).append("\n"); 
		query.append(",	@[hbl_no]" ).append("\n"); 
		query.append(",	@[bl_mk_desc]" ).append("\n"); 
		query.append(",	@[bl_gds_desc]" ).append("\n"); 
		query.append(",	@[hbl_wgt]" ).append("\n"); 
		query.append(",	@[wgt_ut_cd]" ).append("\n"); 
		query.append(",	@[pck_qty]" ).append("\n"); 
		query.append(",	@[pck_tp_cd]" ).append("\n"); 
		query.append(",	@[cmdt_meas_ut_cd]" ).append("\n"); 
		query.append(",	@[cmdt_meas_qty]" ).append("\n"); 
		query.append(",	@[xter_si_no]" ).append("\n"); 
		query.append(",	@[xter_si_seq]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}