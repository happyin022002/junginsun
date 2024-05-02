/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeCUSMODBlFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.04
*@LastModifier :
*@LastVersion : 1.0
* 2012.12.04
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeCUSMODBlFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * CUSMOD FLATFILE
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeCUSMODBlFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_desc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bd_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kr_cstms_bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_corr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_dept_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOmakeCUSMODBlFlatFileRSQL").append("\n");
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
		query.append("SELECT	MAX(" ).append("\n");
		query.append("TO_CHAR(@[cstms_ofc_cty_cd],'FM000')	||'~'||		/*	Customs Office		*/" ).append("\n");
		query.append("TO_CHAR(@[kr_cstms_dept_cd],'FM00')		||'~'||		/*	Customs Department	*/" ).append("\n");
		query.append("@[sub_no]								||'~'||		/*	Submit No.			*/" ).append("\n");
		query.append("@[kr_cstms_corr_id]						||'~'||		/*	Correction Code		*/" ).append("\n");
		query.append("@[bl_no]								||'~'||		/*	B/L No				*/" ).append("\n");
		query.append("@[kr_cstms_bl_tp_cd]					||'~'||		/*	B/L Type			*/" ).append("\n");
		query.append("" ).append("\n");
		query.append("@[cstms_decl_tp_cd]						||'~'||		/*	Trans. Indicator	*/" ).append("\n");
		query.append("@[pod_cd]								||'~'||		/*	Booking POD			*/" ).append("\n");
		query.append("(SELECT DEL_CD FROM BKG_BOOKING WHERE BL_NO=@[bl_no])		||'~'||		/*  Booking DEL         */" ).append("\n");
		query.append("@[pck_qty]								||'~'||		/*	Package Count		*/" ).append("\n");
		query.append("@[pck_tp_cd]							||'~'||		/*	Package Code		*/" ).append("\n");
		query.append("@[corr_rsn]								||'~'||		/*	Correction Reason	*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(@[cgo_desc1],'Y')	||'~'||		/*	Cargo Desc			*/" ).append("\n");
		query.append("TRIM(TO_CHAR(REPLACE(@[cntr_ttl_wgt],',',''),'999,999,999,999,999.99'))||'~'||		/*	Weight				*/" ).append("\n");
		query.append("@[wgt_ut_cd]							||'~'||		/*	Weight Unit			*/" ).append("\n");
		query.append("@[meas_qty]								||'~'||		/*	Measure				*/" ).append("\n");
		query.append("''										||'~'||		/*	House B/L Count		*/" ).append("\n");
		query.append("@[cntr_cnt]								||'~'||		/*	CNTR Count			*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[s_cust_nm],1,35),'Y')    	||'~'||		/*	Shipper Name1		*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[s_cust_addr],1,35),'Y')  	||'~'||		/*	Shipper Addr 1		*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[s_cust_addr],36,35),'Y') 	||'~'||		/*	Shipper Addr 2		*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[s_cust_addr],72,35),'Y') 	||'~'||		/*	Shipper Addr 3		*/" ).append("\n");
		query.append("''                            		  						||'~'||		/*	Shipper Tel			*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[c_cust_nm],1,35),'Y')    	||'~'||		/*	CNEE Name 1			*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[c_cust_addr],1,35),'Y')  	||'~'||		/*	CNEE Addr 1			*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[c_cust_addr],36,35),'Y') 	||'~'||		/*	CNEE Addr 2			*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[c_cust_addr],72,35),'Y') 	||'~'||		/*	CNEE Addr 3			*/" ).append("\n");
		query.append("''             	               		  						||'~'||		/*  CNEE TEL			*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[n_cust_nm],1,35),'Y')    	||'~'||		/*	NTFY Name 1			*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[n_cust_addr],1,35),'Y')  	||'~'||		/*	NTFY Addr1			*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[n_cust_addr],36,35),'Y') 	||'~'||		/*	NTFY Addr2			*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[n_cust_addr],72,35),'Y') 	||'~'||		/*	NTFY Addr3			*/" ).append("\n");
		query.append("''                            		  						||'~'||		/*	NTFY TEL			*/" ).append("\n");
		query.append("''									  						||'~'||		/*	화물운송주선업자	*/" ).append("\n");
		query.append("@[bd_area_cd]												||'~'||		/*	장치장코드			*/" ).append("\n");
		query.append("''																		/*  UCR NO              */" ).append("\n");
		query.append(")" ).append("\n");
		query.append("FROM	DUAL" ).append("\n");

	}
}