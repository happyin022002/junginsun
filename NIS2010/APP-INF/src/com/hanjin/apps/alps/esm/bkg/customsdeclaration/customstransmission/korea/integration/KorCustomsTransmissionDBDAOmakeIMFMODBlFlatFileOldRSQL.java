/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeIMFMODBlFlatFileOldRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeIMFMODBlFlatFileOldRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IMFMOD
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeIMFMODBlFlatFileOldRSQL(){
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
		params.put("sub_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dept_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_desc2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bd_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kr_wh_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_wh_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOmakeIMFMODBlFlatFileOldRSQL").append("\n"); 
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
		query.append("SELECT  MAX(" ).append("\n"); 
		query.append("        '5LI'                                     ||'~'||     /*  Message Code        */" ).append("\n"); 
		query.append("        @[sub_no]                                 ||'~'||     /*  MSG No., Submit No. */" ).append("\n"); 
		query.append("        TO_CHAR(SYSDATE,'YYYYMMDDHH24MI')         ||'~'||     /*  전송 Date & Time    */" ).append("\n"); 
		query.append("        TO_CHAR(@[ofc_cd],'FM000')      		  ||'~'||     /*  Customs Office      */" ).append("\n"); 
		query.append("        TO_CHAR(@[dept_cd],'FM00')       ||'~'||     /*  Customs Department  */ /* 수입정정의 경우 무조건 '10' */" ).append("\n"); 
		query.append("        SUBSTR(@[user_name],1,35)                 ||'~'||     /*  정정 신청자 성명    */" ).append("\n"); 
		query.append("        DECODE(@[kr_cstms_corr_id],'D','C','F','D',@[kr_cstms_corr_id]) ||'~'||     /*  Correction Code     */" ).append("\n"); 
		query.append("        @[corr_rsn]                               ||'~'||     /*  Correction Reason   */" ).append("\n"); 
		query.append("        @[msn_no]                                 ||'~'||     /*  M-B/L Sequence No.  */" ).append("\n"); 
		query.append("        @[bl_no]                                  ||'~'||     /*  B/L No              */" ).append("\n"); 
		query.append("        @[kr_cstms_bl_tp_cd]                      ||'~'||     /*  B/L Type            */" ).append("\n"); 
		query.append("        @[frt_fwrd_cd]                            ||'~'||     /*  Forward Code        */" ).append("\n"); 
		query.append("        @[cstms_decl_tp_cd]                       ||'~'||     /*  Trans. Indicator    */" ).append("\n"); 
		query.append("        @[pol_cd]                                 ||'~'||     /*  Booking POL         */" ).append("\n"); 
		query.append("        @[pod_cd]                                 ||'~'||     /*  Booking POD         */" ).append("\n"); 
		query.append("        @[bd_area_cd]                             ||'~'||     /*  장치장코드          */" ).append("\n"); 
		query.append("        @[kr_cstms_wh_tp_cd]||@[kr_wh_cd]         ||'~'||     /*  하선 장소           */" ).append("\n"); 
		query.append("        @[pck_qty]                                ||'~'||     /*  Package Count       */" ).append("\n"); 
		query.append("        @[pck_tp_cd]                              ||'~'||     /*  Package Code        */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(@[cgo_desc1],'Y')   ||'~'||     /*  Cargo Description1  */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(@[cgo_desc2],'Y')   ||'~'||     /*  Cargo Description2  */" ).append("\n"); 
		query.append("        @[imdg_clss_cd]                           ||'~'||     /*  IMO Class 1         */" ).append("\n"); 
		query.append("        @[n2nd_imdg_clss_cd]                      ||'~'||     /*  IMO Class 2         */" ).append("\n"); 
		query.append("        @[n3rd_imdg_clss_cd]                      ||'~'||     /*  IMO Class 3         */" ).append("\n"); 
		query.append("        TRIM(TO_CHAR(REPLACE(@[cntr_ttl_wgt],',',''),'999999999999999.99'))||'~'||     /*  Weight              */" ).append("\n"); 
		query.append("        @[meas_qty]		                          ||'~'||     /*  Measure             */" ).append("\n"); 
		query.append("        ''                                        ||'~'||     /*  H-B/L Count (?)     */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[s_cust_nm],1,35),'Y')      ||'~'||     /*  Shipper Name1       */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[s_cust_addr],1,35),'Y')    ||'~'||     /*  Shipper Addr 1      */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[s_cust_addr],36,35),'Y')   ||'~'||     /*  Shipper Addr 2      */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[s_cust_addr],72,35),'Y')   ||'~'||     /*  Shipper Addr 3      */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[c_cust_nm],1,35),'Y')      ||'~'||     /*  CNEE Name 1         */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[c_cust_addr],1,35),'Y')    ||'~'||     /*  CNEE Addr 1         */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[c_cust_addr],36,35),'Y')   ||'~'||     /*  CNEE Addr 2         */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[c_cust_addr],72,35),'Y')   ||'~'||     /*  CNEE Addr 3         */" ).append("\n"); 
		query.append("        @[biz_no]                                 ||'~'||     /*  CNEE 사업자등록번호 */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[n_cust_nm],1,35),'Y')      ||'~'||     /*  NTFY Name 1         */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[n_cust_addr],1,35),'Y')    ||'~'||     /*  NTFY Addr1          */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[n_cust_addr],36,35),'Y')   ||'~'||     /*  NTFY Addr2          */" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[n_cust_addr],72,35),'Y')   ||'~'||     /*  NTFY Addr3          */" ).append("\n"); 
		query.append("        @[biz_no]                                                 /*  NTFY 사업자등록번호 */" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}