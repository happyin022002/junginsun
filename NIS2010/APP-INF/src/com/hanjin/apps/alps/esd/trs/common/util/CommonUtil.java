/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESUtil
*@FileTitle : TES UTIL
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.util;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;

/**
 * - TRS의 공통 UTIL
 * 
 * @author trs
 * @see 
 * @since J2EE 1.6
 */
public class CommonUtil {

    /**
     * @param src
     * @param delim
     * @return
     */
    public static String[] getStringToArray(String src, String delim) {
        String[] retval = null;
        if(src != null) {
	        StringTokenizer st = new StringTokenizer(src, delim);

	        int count = st.countTokens();
	        retval = new String[count];
	        for (int i = 0; i < count; i++) {
	        	retval[i] = st.nextToken();
	        }
        }

        return retval;
    }	
    
    /**
     * @param str
     * @return
     */
    public static String convertSpecialCharacter(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        } else {
            String retval = null;
            retval = JSPUtil.replace(str	, "&"	, "&amp;"	);
            retval = JSPUtil.replace(retval	, "<"	, "&lt;"	);
            retval = JSPUtil.replace(retval	, ">"	, "&gt;"	);
            retval = JSPUtil.replace(retval	, "\""	, "&quot;"	);
            retval = JSPUtil.replace(retval	, "\'"	, "&apos;"	);
            return retval;
        }
    }

	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public static ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if(sparameter != null && !sparameter.equals("")) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public static ArrayList seperationParameterPlusQuotation(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if(sparameter != null && !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, "'" + st.nextToken() + "'");
			}
		}
		return arrlist;
	}
    
	
	public static void  modifyMasCommonInterface(String bkg_no, String  desc,String user_id) throws EventException {
		CostAssignBC masCommand = new CostAssignBCImpl();
		MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
		
		masBkgComIfVo.setBkgNo(bkg_no);
		masBkgComIfVo.setCostSrcSysCd("TRS");//TRS, TES, SCE, BKG등 SUB SYSTEM CODE
		masBkgComIfVo.setIfRmk(desc);
		masBkgComIfVo.setCreUsrId(user_id);
		masBkgComIfVo.setUpdUsrId(user_id);

		int result_cnt;
		try {
			result_cnt = masCommand.modifyMasCommonInterface(masBkgComIfVo);
			
			if (result_cnt < 0)
				throw new EventException((new ErrorHandler("TRS00099",new String[]{"MAS I/F Error"})).getMessage());
		} catch (EventException de) {
			throw new EventException(de.getMessage());
		}
	}
}
