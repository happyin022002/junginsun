/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOMakeFlatFileMACAMDRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.03 손윤석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOMakeFlatFileMACAMDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MakeFlatFileMACAMD
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOMakeFlatFileMACAMDRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disc_md",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("disc_co",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_un",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mton_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sign",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imo_class1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imo_class2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mea_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imo_class3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bond_area_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quay_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_un",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kv_in_cnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_pa2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT MAX(" ).append("\n");
		query.append("'$$$MSGSTART:'	||									/*	Message Header	*/" ).append("\n");
		query.append("RPAD('HJSPORT1',20)||						                        /*	- Sender ID	*/" ).append("\n");
		query.append("RPAD(DECODE(@[kt_pa2],20,'BPAED020',30,'KMPAE030',31,'KMPAE030',622,'KMPAE050',16,'KMPAE030'),20)||" ).append("\n");
		query.append("RPAD('MACAMD',10)			||CHR(10)||		/*	- Message Type	*/" ).append("\n");
		query.append("'MSG_CD:'		||DECODE(@[bound],'O','6SJ','6SK')	||CHR(10)||		/*	Message Code	*/" ).append("\n");
		query.append("'MSG_NO:'		||								/*	Message No.	*/" ).append("\n");
		query.append("TO_CHAR(@[kt_pa2],'FM000')||					                        /*	- 청코드		*/" ).append("\n");
		query.append("@[call_year]		||								/*	- 입항 년도	*/" ).append("\n");
		query.append("TO_CHAR(@[kv_in_cnt2],'FM000')||		                         /*	- 입항 회수	*/" ).append("\n");
		query.append("SUBSTR(@[call_sign],1,9)					||CHR(10)||     /*	- Call Sign		*/" ).append("\n");
		query.append("'SEND_DT:'		||TO_CHAR(SYSDATE,'YYYYMMDDHH24MI')	||CHR(10)||     /*	전송 Date & Time	        */" ).append("\n");
		query.append("'PORT_CD:'		||TO_CHAR(@[kt_pa2],'FM000')              ||CHR(10)||     /*	청 코드	                */" ).append("\n");
		query.append("'MRN_NO:'		||@[mrn_no]				||CHR(10)||     /*	Manifest Reference#	*/" ).append("\n");
		query.append("'SCAC:'			||COM_ConstantMgr_PKG.COM_getScacCode_FNC()               	||CHR(10)||	/*	SCAC			*/" ).append("\n");
		query.append("'CARRIER_CD:'	||DECODE(@[kt_pa2],20,'BS-Z-8828','KM-S-8828')    ||CHR(10)||     /*	선사/대리점 코드	        */" ).append("\n");
		query.append("'VVD:'			||@[vsl_cd]				||CHR(10)||     /*	VVD			*/" ).append("\n");
		query.append("'CALLSIGN:'		||SUBSTR(@[call_sign],1,9)		||CHR(10)||     /*	Call Sign		*/" ).append("\n");
		query.append("'VSL_NAME:'		||FC2S(SUBSTR(@[vsl_name],1,17),'S')	||CHR(10)||	/*	Vessel Name		*/" ).append("\n");
		query.append("'VSL_FLAG:'		||@[vsl_flag]			||CHR(10)||     /*  Vessel Flag			*/" ).append("\n");
		query.append("'ETA:'			||@[call_year]			||CHR(10)||     /*	입항 년도			*/" ).append("\n");
		query.append("'IN_SEQ:'		||TO_CHAR(@[kv_in_cnt2],'FM000')          ||CHR(10)||     /*	입항 회수			*/" ).append("\n");
		query.append("'BL_NO:'		    ||@[bl_no]		        ||CHR(10)||	/*	B/L No			*/" ).append("\n");
		query.append("'MSN_NO:'		||@[msn_no]				||CHR(10)||	/*	M-B/L Sequence No.	*/" ).append("\n");
		query.append("'CORR_CD:'		||'A'                   ||CHR(10)|| /*  Correction Code             */" ).append("\n");
		query.append("/* 일괄삭제,정정은 운항정보정정..'A' */" ).append("\n");
		query.append("'BL_TP:'		    ||@[bl_tp]				||CHR(10)||	/*	B/L Type		*/" ).append("\n");
		query.append("'CGO_TP:'		||@[kcd_tp]				||CHR(10)||	/*	Trans. Indicator	*/" ).append("\n");
		query.append("'DISC_MD_CD:'	||@[disc_md]           	||CHR(10)||     /*	하역방법,2-기계하역	*/" ).append("\n");
		query.append("'BKG_POL:'		||@[bkg_pol_un]			||CHR(10)||     /*	Booking POL		*/" ).append("\n");
		query.append("'BKG_POD:'		||@[bkg_pod_un]			||CHR(10)||     /*	Booking POD		*/" ).append("\n");
		query.append("'QUAY_CD:'		||@[quay_cd2]           ||CHR(10)||     /*	반출입 부두 코드	        */" ).append("\n");
		query.append("'BOND_AREA_CODE:'||@[bond_area_code]		||CHR(10)||	/*	장치장코드		*/" ).append("\n");
		query.append("'PKG_CD:'		||@[pkg_cd]				||CHR(10)||	/*	Package Code		*/" ).append("\n");
		query.append("'CGO_CD:'		||@[cgo_cd]				||CHR(10)||	/*	품목 코드, HS Code	*/" ).append("\n");
		query.append("'CGO_DESC1:'	    ||FC2S(@[cgo_desc1],'S')		||CHR(10)||	/*	Cargo Description1	*/" ).append("\n");
		query.append("'CGO_DESC2:'	    ||FC2S(@[cgo_desc2],'S')		||CHR(10)||	/*	Cargo Description2	*/" ).append("\n");
		query.append("'IMO_CLASS1:'	||@[imo_class1]					||CHR(10)||     /*	IMO Class 1		*/" ).append("\n");
		query.append("'IMO_CLASS2:'	||@[imo_class2]					||CHR(10)||     /*	IMO Class 2		*/" ).append("\n");
		query.append("'IMO_CLASS3:'	||@[imo_class3]					||CHR(10)||     /*	IMO Class 3		*/" ).append("\n");
		query.append("'WGT:'			||@[wgt_qty]				    ||CHR(10)||	/*	Weight			*/" ).append("\n");
		query.append("'MEA_TP:'		||@[mton_tp]				    ||CHR(10)||     /*	용적톤 단위		*/" ).append("\n");
		query.append("'MEA:'			||@[mea_qty]				    ||CHR(10)||	/*	Measure			*/" ).append("\n");
		query.append("'SHPR1:'		    ||FC2S(SUBSTR(@[shpr_cust_nm],1,35),'S')    	||CHR(10)||	/*	Shipper Name1		*/" ).append("\n");
		query.append("'SHPR2:'		    ||FC2S(SUBSTR(@[shpr_cust_addr],1,35),'S')  	||CHR(10)||	/*	Shipper Addr 1		*/" ).append("\n");
		query.append("'SHPR3:'		    ||FC2S(SUBSTR(@[shpr_cust_addr],36,35),'S') 	||CHR(10)||	/*	Shipper Addr 2		*/" ).append("\n");
		query.append("'SHPR4:'		    ||FC2S(SUBSTR(@[shpr_cust_addr],72,35),'S') 	||CHR(10)||	/*	Shipper Addr 3		*/" ).append("\n");
		query.append("'CNEE1:'		    ||FC2S(SUBSTR(@[cnee_cust_nm],1,35),'S')    	||CHR(10)||	/*	CNEE Name 1		*/" ).append("\n");
		query.append("'CNEE2:'		    ||FC2S(SUBSTR(@[cnee_cust_addr],1,35),'S')  	||CHR(10)||	/*	CNEE Addr 1		*/" ).append("\n");
		query.append("'CNEE3:'		    ||FC2S(SUBSTR(@[cnee_cust_addr],36,35),'S') 	||CHR(10)||	/*	CNEE Addr 2		*/" ).append("\n");
		query.append("'CNEE4:'		    ||FC2S(SUBSTR(@[cnee_cust_addr],72,35),'S') 	||CHR(10)||	/*	CNEE Addr 3		*/" ).append("\n");
		query.append("'NTFY1:'		    ||FC2S(SUBSTR(@[ntfy_cust_nm],1,35),'S')    	||CHR(10)||	/*	NTFY Name 1		*/" ).append("\n");
		query.append("'NTFY2:'		    ||FC2S(SUBSTR(@[ntfy_cust_addr],1,35),'S')  	||CHR(10)||	/*	NTFY Addr1		*/" ).append("\n");
		query.append("'NTFY3:'		    ||FC2S(SUBSTR(@[ntfy_cust_addr],36,35),'S') 	||CHR(10)||	/*	NTFY Addr2		*/" ).append("\n");
		query.append("'NTFY4:'		    ||FC2S(SUBSTR(@[ntfy_cust_addr],72,35),'S') 	||CHR(10)||	/*	NTFY Addr3		*/" ).append("\n");
		query.append("'DISC_CO_CD:'	||@[disc_co]                                 	||CHR(10)||	/*	하역회사 부호,(주)한진     */" ).append("\n");
		query.append("'GO_BIZ_NO:'	    ||@[biz_no]							/*	사업자 등록 번호	        */" ).append("\n");
		query.append(")||CHR(10) FLAT_DATA" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration ").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOMakeFlatFileMACAMDRSQL").append("\n");
		query.append("*/").append("\n");
	}
}